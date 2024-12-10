import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое дробное число:");
        double num1 = scanner.nextDouble();

        System.out.println("Введите второе дробное число:");
        double num2 = scanner.nextDouble();

        System.out.println("Введите третье дробное число:");
        double num3 = scanner.nextDouble();

        if (Math.sqrt(num1) < 2) {
            System.out.println("корень квадратный числа " + num1 + " меньше 2");
        }

        if (Math.sqrt(num2) < 2) {
            System.out.println("корень квадратный числа " + num2 + " меньше 2");
        }

        if (Math.sqrt(num3) < 2) {
            System.out.println("корень квадратный числа " + num3 + " меньше 2");
        }

    }
}
