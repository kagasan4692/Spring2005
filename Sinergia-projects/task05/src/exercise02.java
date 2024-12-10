import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввудите первое число");
        double number1 = scanner.nextDouble();

        System.out.println("Ввудите первое число");
        double number2 = scanner.nextDouble();

        double result1 = Math.pow(number1, number2);

        System.out.println("Ввудите третье число");
        double number3 = scanner.nextDouble();

        double result = Math.pow(result1, number3);

        System.out.println(result);
    }
}
