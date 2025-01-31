package data.data_sources.cart;

import data.moduls.CartItem;
import data.moduls.Product;

import java.util.ArrayList;

public abstract class CartDataSource {

    public abstract void addToCart(Product product, int count);

    public abstract ArrayList<CartItem> getCart();

    public abstract void clearCart();

}
