package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;

public class ClearCartView extends AppView {
    private final ShopService shopService;

    public ClearCartView(ShopService shopService) {
        super("Очистить корзину", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        shopService.clearCart();
    }
}
