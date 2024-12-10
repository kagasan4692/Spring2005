import java.io.IOException;
import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");

        try {
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                System.out.println("Вы ввели число: " + number);
            } else {
                RuntimeException exception = new RuntimeException("Ввод некорректный. Пожалуйста, введите число.");
                throw exception;
            }

        } catch (RuntimeException exception) {
             exception.printStackTrace();
        }


    }
}
