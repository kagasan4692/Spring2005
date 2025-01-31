package view;

import common.AppView;
import data.moduls.CartItem;
import data.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {


    public CartView(ShopService shopService) {
        super("Корзина", new ArrayList<>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.product.id + " " + cartItem.product.title + " " + cartItem.count);
        }
    }
}
