package common;

import java.util.List;
import java.util.Scanner;

public class PageLoop {
    private final AppView view;
    private final Scanner scanner;

    public PageLoop(AppView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            view.action();
            displayChildren();

            int value = getUserInput(view.getChildren().size());
            if (value == -1) {
                System.out.println("Выход из программы.");
                break;
            }
            if (value == view.getChildren().size()) {
                break;
            }

            new PageLoop(view.getChildren().get(value), scanner).run();
        }
    }

    private void displayChildren() {
        System.out.println("\n" + view.getTitle());
        System.out.println("Выберите вариант (от 1 до " + (view.getChildren().size() + 1) + "):");

        List<AppView> children = view.getChildren();
        for (int i = 0; i < children.size(); i++) {
            System.out.println((i + 1) + " - " + children.get(i).getTitle());
        }
        System.out.println((children.size() + 1) + " - Назад");
        System.out.println("0 - Выйти");
    }

    private int getUserInput(int max) {
        while (true) {
            System.out.print("Ваш выбор: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();

                if (value > 0 && value <= max + 1) {
                    return value - 1;
                } else if (value == 0) {
                    System.out.println("Программа завершена!");
                    System.exit(0);
                }
            } else {
                scanner.next();
            }
            System.out.println("Неверное значение. Попробуйте снова.");
        }
    }
}
