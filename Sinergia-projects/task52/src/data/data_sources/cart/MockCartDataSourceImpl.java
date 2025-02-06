package data.data_sources.cart;

import data.moduls.CartItem;
import data.moduls.Product;

import java.util.ArrayList;
import java.util.List;

public class MockCartDataSourceImpl extends CartDataSource {

    private final List<CartItem> cart = new ArrayList<>();

    @Override
    public void addToCart(Product product, int count) {
        if (product == null || count <= 0) {
            System.err.println("Ошибка: Неверные данные для добавления в корзину.");
            return;
        }

        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setCount(item.getCount() + count);
                return;
            }
        }
        cart.add(new CartItem(product, count));
    }

    @Override
    public List<CartItem> getCart() {
        return new ArrayList<>(cart);
    }

    @Override
    public void clearCart() {
        cart.clear();
    }
}
