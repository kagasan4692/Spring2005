import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number;

        while (true) {
            System.out.println("Введите число: ");
            try {
                if (scanner.hasNextDouble()) {
                    number = scanner.nextDouble();
                    System.out.println("Вы ввели число: " + number);
                    break;
                } else {
                    throw new RuntimeException("Ввод некорректный. Пожалуйста, введите число.");
                }

            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
                scanner.next();
            }

        }

        scanner.close();
        System.out.println("Вы - молодец!");
    }
}
