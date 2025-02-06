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
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            CartDataSource cartDataSource = new MockCartDataSourceImpl();
            CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
            OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
            ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

            AppView addToCartView = new AddToCartView(shopService, scanner);
            AppView cartView = new CartView(shopService);
            AppView orderView = new OrderView(shopService, scanner);
            AppView clearCartView = new ClearCartView(shopService, scanner);

            List<AppView> catalogChildren = List.of(addToCartView);
            AppView catalogView = new CatalogView(catalogChildren, shopService);

            List<AppView> mainChildren = List.of(catalogView, orderView, cartView, clearCartView);
            AppView mainView = new MainView(mainChildren);

            new PageLoop(mainView, scanner).run();

            scanner.close();
        }
}
