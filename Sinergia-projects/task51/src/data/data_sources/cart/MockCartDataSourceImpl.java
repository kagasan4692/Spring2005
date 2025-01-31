package data.data_sources.cart;

import data.moduls.CartItem;
import data.moduls.Product;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource {

    private ArrayList<CartItem> cart = new ArrayList<>();

    @Override
    public void addToCart(Product product, int count) {
        cart.add(new CartItem(product, count));
    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    @Override
    public void clearCart() {

    }
}
