package data.service;

import data.data_sources.cart.CartDataSource;
import data.data_sources.catalog.CatalogDataSource;
import data.data_sources.order.OrderDataSource;
import data.moduls.CartItem;
import data.moduls.Order;
import data.moduls.Product;

import java.util.List;

public class ShopService {
    private final CatalogDataSource catalogDataSource;
    private final CartDataSource cartDataSource;
    private final OrderDataSource orderDataSource;

    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }

    public List<Product> getCatalog() {
        return catalogDataSource.getCatalog();
    }

    public boolean addToCart(String productId, int count) {
        List<Product> products = getCatalog();
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                if (product.getStock() >= count) {
                    cartDataSource.addToCart(product, count);
                    product.setStock(product.getStock() - count);
                    return true;
                } else {
                    System.err.println("Ошибка: недостаточно товара на складе! Доступно: " + product.getStock());
                    return false;
                }
            }
        }
        System.err.println("Ошибка: товар не найден!");
        return false;
    }

    public List<CartItem> getCart() {
        return cartDataSource.getCart();
    }

    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime) {
        List<CartItem> cart = getCart();

        if (cart.isEmpty()) {
            System.err.println("Ошибка: корзина пуста! Добавьте товары перед заказом.");
            return;
        }

        Order newOrder = new Order(name, phone, address, paymentType, deliveryTime, cart);
        orderDataSource.createOrder(newOrder);

        cartDataSource.clearCart();
        System.out.println("Заказ успешно оформлен!");
    }

    public void clearCart() {
        cartDataSource.clearCart();
        System.out.println("Корзина успешно очищена!");
    }
}
