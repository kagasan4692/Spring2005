package view;

import common.AppView;
import data.moduls.Product;
import data.service.ShopService;
import java.util.List;

public class CatalogView extends AppView {
    private final ShopService shopService;

    public CatalogView(List<AppView> children, ShopService shopService) {
        super("Каталог", children);
        this.shopService = shopService;
    }

    @Override
    public void action() {
        List<Product> catalog = shopService.getCatalog();
        if (catalog.isEmpty()) {
            System.out.println("Каталог пуст.");
            return;
        }
        for (Product product : catalog) {
            System.out.println(product.getId() + " " +
                    product.getTitle() + " " +
                    product.getPrice() + " руб. (в наличии: " +
                    product.getStock() + ")");
        }
    }
}
