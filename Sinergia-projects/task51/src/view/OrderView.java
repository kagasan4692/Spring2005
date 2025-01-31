package view;

import common.AppView;
import data.moduls.CartItem;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    private ArrayList<CartItem> cart;

    public OrderView(ShopService shopService) {
        super("Оформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        cart = shopService.getCart();
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста! Добавьте товары перед оформлением заказа.");
            return;
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Введите свое имя:");
        String name = in.nextLine();
        System.out.println("Введите свой телефон:");
        String phone = in.nextLine();
        System.out.println("Введите адрес доставки:");
        String address = in.nextLine();
        System.out.println("Выберите способ оплаты (наличными/картой):");
        String paymentType = in.nextLine();
        String deliveryTime = "18-19 часов";

        shopService.createOrder(name, phone, address, paymentType, deliveryTime);
        printOrderView(name, phone, address, paymentType, deliveryTime);

        shopService.clearCart();
    }

    private void printOrderView(String name, String phone, String address, String paymentType, String deliveryTime) {
        separator();
        System.out.println("| Детали заказа:");
        separator();
        System.out.println("| Имя: " + name);
        System.out.println("| Телефон: " + phone);
        System.out.println("| Адрес: " + address);
        System.out.println("| Способ оплаты: " + paymentType);
        System.out.println("| Время доставки: " + deliveryTime);
        separator();
        System.out.print("| Состав заказа:");
        int total = 0;
        for (CartItem item : cart) {
            int cost = item.product.price * item.count;
            total += cost;
            System.out.println("- " + item.product.title + " x" + item.count + " = " + cost + " руб.");
        }

        System.out.println("| Итоговая сумма: " + total + " руб.");
        separator();
    }

    private void separator() {
        System.out.println("-----------------------------");
    }
}
