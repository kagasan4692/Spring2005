import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0;
        int numberA = 0;
        int i = 0;
        while (i < 4) {
            i++;
            System.out.println("Введите " + i + " число:");

            int numberB = scanner.nextInt();

            if (i == 1) {
                numberA = numberB;
            } else {
                if (numberA < numberB) {
                    max = numberB;
                } else {
                    max = numberA;
                }
            }
        }

        System.out.println("Наибольшее число:" + max);
    }
}
