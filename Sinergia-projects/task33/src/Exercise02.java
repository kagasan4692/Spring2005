import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        Double num1 = readDouble(scanner);
        if (num1 == null) {
            exceptionCalc("Ошибка: некорректный ввод числа.");
//            return;
        }

        System.out.println("Введите оператор (+, -, *, /): ");
        char operator = readOperator(scanner);
        if (operator == ' ') {
            exceptionCalc("Ошибка: некорректный оператор.");
//            return;
        }

        System.out.println("Введите второе число: ");
        Double num2 = readDouble(scanner);
        if (num2 == null) {
            exceptionCalc("Ошибка: некорректный ввод числа.");
//            return;
        }

        if (operator == '/' && num2 == 0) {
            exceptionCalc("Ошибка: деление на ноль невозможно.");
//            return;
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

    private static Double readDouble(Scanner scanner) {
        if (!scanner.hasNextDouble()) {
            scanner.next();
            return null;
        }
        return scanner.nextDouble();
    }

    private static char readOperator(Scanner scanner) {
        String input = scanner.next();
        if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
            return input.charAt(0);
        }
        return ' ';
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
                return null; // Некорректный оператор
        }
    }
}
