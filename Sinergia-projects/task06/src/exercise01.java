import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дробное число:");

        double number = scanner.nextDouble();

        if (number > Math.PI) {
            System.out.println("pimore");
        }

    }
}
