package view;

import common.AppView;
import data.service.ShopService;

import java.util.List;
import java.util.Scanner;

public class AddToCartView extends AppView {
    private final ShopService shopService;
    private final Scanner scanner;

    public AddToCartView(ShopService shopService, Scanner scanner) {
        super("Добавить товар в корзину", List.of());
        this.shopService = shopService;
        this.scanner = scanner;
    }

    @Override
    public void action() {
        System.out.print("Введите id продукта: ");
        String productId = scanner.nextLine().trim();

        if (productId.isEmpty()) {
            System.err.println("Ошибка: ID товара не может быть пустым.");
            return;
        }

        System.out.print("Введите количество: ");
        while (!scanner.hasNextInt()) {
            System.err.println("Ошибка: количество должно быть числом.");
            scanner.next();
        }
        int count = scanner.nextInt();
        scanner.nextLine();

        if (count <= 0) {
            System.err.println("Ошибка: количество должно быть положительным числом.");
            return;
        }

        if (shopService.addToCart(productId, count)) {
            System.out.println("Товар успешно добавлен!");
        } else {
            System.err.println("Не удалось добавить товар.");
        }
    }
}
