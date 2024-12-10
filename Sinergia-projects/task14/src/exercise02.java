import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        int[] firstArray = new int[10];

        for (int index = 0; index < firstArray.length; index++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите " + (index + 1) + " число:");

            int data = scanner.nextInt();
            firstArray[index] = data;
        }

        for (int index = firstArray.length - 1; index >= 0; index--) {
            System.out.println(firstArray[index]);

        }

    }
}
