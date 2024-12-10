import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char char1;
        double result = 0;

        System.out.println("Вводите данные с клавиатуры для осуществления математических операций");
        double number1 = scanner.nextDouble();

        char1 = scanner.next().charAt(0);

        double number2 = scanner.nextDouble();

        if (char1 == '+') {
            result = number1 + number2;
        }
        if (char1 == '-') {
            result = number1 - number2;
        }
        if (char1 == '*') {
            result = number1 * number2;
        }
        if (char1 == '/') {
            result = number1 / number2;
        }

        char1 = scanner.next().charAt(0);

        double number3 = scanner.nextDouble();

        if (char1 == '+') {
            result = result + number3;
        }
        if (char1 == '-') {
            result = result - number3;
        }
        if (char1 == '*') {
            result = result * number3;
        }
        if (char1 == '/') {
            result = result / number3;
        }

        System.out.println("=");
        System.out.println(result);
    }
}
