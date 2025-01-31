package data.service;

import common.AppView;
import data.data_sources.cart.CartDataSource;
import data.data_sources.catalog.CatalogDataSource;
import data.data_sources.order.OrderDataSource;
import data.moduls.CartItem;
import data.moduls.Order;
import data.moduls.Product;

import java.util.ArrayList;

public class ShopService {
    final CatalogDataSource catalogDataSource;
    final CartDataSource cartDataSource;
    final OrderDataSource orderDataSource;

    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog() {
        return catalogDataSource.getCatalog();
    }

    public boolean addToCart(String productId, int count) {
        ArrayList<Product> products = getCatalog();
        for (Product p : products) {
            if (p.id.equals(productId)) {
                if (p.stock >= count) {
                    cartDataSource.addToCart(p, count);
                    p.stock -= count;
                    return true;
                } else {
                    System.out.println("Ошибка: недостаточно товара на складе! Доступно: " + p.stock);
                    return false;
                }
            }
        }
        System.out.println("Ошибка: товар не найден!");

        return false;
    }

    public ArrayList<CartItem> getCart() {
        return cartDataSource.getCart();
    }

    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime) {
        ArrayList<CartItem> cart = getCart();

        if (cart.isEmpty()) {
            System.out.println("Ошибка: корзина пуста! Добавьте товары перед заказом.");
            return;
        }

        Order newOrder = new Order(name, phone, address, paymentType, deliveryTime, cart);
        orderDataSource.createOrder(newOrder);

        cartDataSource.clearCart();
        System.out.println("Заказ успешно оформлен!");
    }

    public void clearCart() {
        cartDataSource.getCart().clear();
        System.out.println("Корзина очищена.");
    }
}
