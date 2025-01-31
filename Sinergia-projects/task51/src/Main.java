import common.AppView;
import common.PageLoop;
import data.data_sources.cart.CartDataSource;
import data.data_sources.cart.MockCartDataSourceImpl;
import data.data_sources.catalog.CatalogDataSource;
import data.data_sources.catalog.MockCatalogDataSourceImpl;
import data.data_sources.order.MockOrderDataSourceImpl;
import data.data_sources.order.OrderDataSource;
import data.service.ShopService;
import view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        AppView catalogView = new CatalogView(catalogChildren, shopService);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);
        AppView addProductView = new AddToCartView(shopService);
        AppView clearCart = new ClearCartView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(addProductView);
        mainChildren.add(orderView);
        mainChildren.add(cartView);
        mainChildren.add(clearCart);

        AppView mainView = new MainView(mainChildren, shopService);

        System.out.println(shopService.getCatalog());

        new PageLoop(mainView).run();


//        System.out.println(shopService.getCart());
//        System.out.println(shopService.addToCart(shopService.getCatalog().get(1).id, 10));
//        System.out.println(shopService.addToCart(shopService.getCatalog().get(2).id, 10));
//        System.out.println(shopService.getCart());
//        System.out.println(shopService.getCatalog());
    }
}
