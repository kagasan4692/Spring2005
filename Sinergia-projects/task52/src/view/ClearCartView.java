package view;

import common.AppView;
import data.service.ShopService;
import java.util.List;
import java.util.Scanner;

public class ClearCartView extends AppView {
    private final ShopService shopService;
    private final Scanner scanner;

    public ClearCartView(ShopService shopService, Scanner scanner) {
        super("Очистить корзину", List.of());
        this.shopService = shopService;
        this.scanner = scanner;
    }

    @Override
    public void action() {
            System.out.print("Вы уверены, что хотите очистить корзину? (да/нет): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("да")) {
                shopService.clearCart();
            } else {
                System.out.println("Очистка корзины отменена.");
            }
        }
}
