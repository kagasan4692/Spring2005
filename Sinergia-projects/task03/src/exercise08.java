import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double num1 = scanner.nextInt();

        System.out.println("Введите второе число:");
        double num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println(num2 / num1);
        } else {
            System.out.println(num1 / num2);
        }
    }
}
