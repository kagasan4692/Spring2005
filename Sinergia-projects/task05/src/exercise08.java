import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double result = 0;

        System.out.println("Вводите данные с клавиатуры для осуществления математических операций");
        double number1 = scanner.nextDouble();

        char char1 = scanner.next().charAt(0);

        double number2 = scanner.nextDouble();

        char char2 = scanner.next().charAt(0);

        double number3 = scanner.nextDouble();

        if ((char1 == '+' || char1 == '-') && (char2 == '+' || char2 == '-')) {

            if (char1 == '+') {
                result = number1 + number2;
            }
            if (char1 == '-') {
                result = number1 - number2;
            }
            if (char2 == '+') {
                result = result + number3;
            }
            if (char2 == '-') {
                result = result - number3;
            }

        } else {

            if (char1 == '*' || char1 == '/') {

                if (char1 == '*') {
                    result = number1 * number2;
                }
                if (char1 == '/') {
                    result = number1 / number2;
                }

                if (char2 == '+') {
                    result = result + number3;
                }
                if (char2 == '-') {
                    result = result - number3;
                }
                if (char2 == '*') {
                    result = result * number3;
                }
                if (char2 == '/') {
                    result = result / number3;
                }

            } else {

                if (char2 == '*' || char2 == '/') {
                    if (char2 == '*') {
                        result = number2 * number3;
                    }
                    if (char2 == '/') {
                        result = number2 / number3;
                    }

                    if (char1 == '+') {
                        result = number1 + result;
                    }
                    if (char1 == '-') {
                        result = number1 - result;
                    }

                } else {

                    if (char1 == '+') {
                        result = number1 + number2;
                    }
                    if (char1 == '-') {
                        result = number1 - number2;
                    }
                }
            }
        }


        System.out.println("=");
        System.out.println(result);
    }
}
