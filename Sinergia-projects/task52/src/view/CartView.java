package view;

import common.AppView;
import data.moduls.CartItem;
import data.service.ShopService;
import java.util.List;

public class CartView extends AppView {
    private final ShopService shopService;

    public CartView(ShopService shopService) {
        super("Корзина", List.of());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        List<CartItem> cart = shopService.getCart();
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.getProduct().getId() + " " +
                    cartItem.getProduct().getTitle() + " x" +
                    cartItem.getCount());
        }
    }
}
