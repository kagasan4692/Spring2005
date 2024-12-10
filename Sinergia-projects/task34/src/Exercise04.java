import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        System.out.println("Введите первое число: ");
        Scanner scanner = new Scanner(System.in);
        Double num1 = exceptionHandlingDouble(scanner);

        System.out.println("Введите оператор (+, -, *, /): ");
        char operator = exceptionHandlingChar(scanner);

        System.out.println("Введите второе число: ");
        Double num2 = exceptionHandlingDouble(scanner);

        if (operator == '/' && num2 == 0) {
            exceptionCalc("Ошибка: деление на ноль невозможно.");
        }

        Double result = calculate(num1, num2, operator);
        if (result == null) {
            exceptionCalc("Ошибка: произошла ошибка в вычислении.");
        } else {
            System.out.println("Результат: " + result);
        }
    }

    private static void exceptionCalc(String message) {
        RuntimeException exception = new RuntimeException(message);
        System.out.println(exception);
        throw exception;
    }


    private static char exceptionHandlingChar(Scanner scanner) {

        String input = scanner.next();

        while (true) {
            try {
                if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {

                    break;
                } else {
                    throw new RuntimeException("Ошибка: некорректный оператор.");

                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите число заново");
                scanner.next();
            }
        }

        return input.charAt(0);
    }

    private static double exceptionHandlingDouble(Scanner scanner) {

        double number;

        while (true) {
            try {
                if (!scanner.hasNextDouble()) {
                    throw new RuntimeException("Ошибка: некорректный ввод числа.");
                } else {
                    number = scanner.nextDouble();
                    break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите число заново");
                scanner.next();
            }
        }

        return number;
    }

    private static Double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return null;
        }
    }
}
