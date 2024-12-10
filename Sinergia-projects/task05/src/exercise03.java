import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввудите первое число");
        double number1 = scanner.nextDouble();

        System.out.println("Ввудите первое число");
        double number2 = scanner.nextDouble();

        System.out.println("Ввудите третье число");
        double number3 = scanner.nextDouble();

        int i = 0;
        double basisDegree = 0;
        double degree = 0;
        double result = 0;
        while (i < 2) {
            i++;
            if (i == 1) {
                basisDegree = number1;
                degree = number2;
            }
            if (i == 2) {
                basisDegree = result;
                degree = number3;
            }
            result = Math.pow(basisDegree, degree);
        }

        System.out.println(result);
    }
}

