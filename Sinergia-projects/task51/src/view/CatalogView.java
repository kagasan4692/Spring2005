package view;

import common.AppView;
import data.moduls.Product;
import data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {


    public CatalogView(ArrayList<AppView> children, ShopService shopService) {
        super("Каталог", children);
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        ArrayList<Product> catalog = shopService.getCatalog();
        for (Product product : catalog) {
            System.out.println(product.id + " " + product.title + " " + product.price + " (в наличии: " + product.stock + ")");
        }
        System.out.println();
    }
}
