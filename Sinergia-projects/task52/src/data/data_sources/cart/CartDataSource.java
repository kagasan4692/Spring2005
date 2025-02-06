package data.data_sources.cart;

import data.moduls.CartItem;
import data.moduls.Product;
import java.util.List;

public abstract class CartDataSource {
    public abstract void addToCart(Product product, int count);
    public abstract List<CartItem> getCart();
    public abstract void clearCart();
}
