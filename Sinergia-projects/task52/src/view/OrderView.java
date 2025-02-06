package view;

import common.AppView;
import data.moduls.CartItem;
import data.service.ShopService;
import java.util.List;
import java.util.Scanner;

public class OrderView extends AppView {
    private final ShopService shopService;
    private final Scanner scanner;

    public OrderView(ShopService shopService, Scanner scanner) {
        super("Оформление заказа", List.of());
        this.shopService = shopService;
        this.scanner = scanner;
    }

    @Override
    public void action() {
        List<CartItem> cart = shopService.getCart();
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста! Добавьте товары перед оформлением заказа.");
            return;
        }
            System.out.print("Введите ваше имя: ");
            String name = scanner.nextLine().trim();
            System.out.print("Введите ваш телефон: ");
            String phone = scanner.nextLine().trim();
            System.out.print("Введите адрес доставки: ");
            String address = scanner.nextLine().trim();
            System.out.print("Выберите способ оплаты (наличными/картой): ");
            String paymentType = scanner.nextLine().trim();
            String deliveryTime = "18-19 часов";

            shopService.createOrder(name, phone, address, paymentType, deliveryTime);
            printOrderSummary(name, phone, address, paymentType, deliveryTime, cart);

            shopService.clearCart();
    }

    private void printOrderSummary(String name, String phone, String address, String paymentType, String deliveryTime, List<CartItem> cart) {
        System.out.println("\n========= Детали заказа =========");
        System.out.println("Имя: " + name);
        System.out.println("Телефон: " + phone);
        System.out.println("Адрес: " + address);
        System.out.println("Способ оплаты: " + paymentType);
        System.out.println("Время доставки: " + deliveryTime);
        System.out.println("========= Состав заказа =========");

        int total = 0;
        for (CartItem item : cart) {
            int cost = item.getProduct().getPrice() * item.getCount();
            total += cost;
            System.out.println(item.getProduct().getTitle() + " x" + item.getCount() + " = " + cost + " руб.");
        }

        System.out.println("========= Итоговая сумма =========");
        System.out.println("Общая сумма заказа: " + total + " руб.");
    }
}
