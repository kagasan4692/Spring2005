import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        int[] firstArray = new int[10];

        for (int index = 0; index < firstArray.length; index++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите " + (index + 1) + " число:");

            int data = scanner.nextInt();
            firstArray[index] = data;
        }

        int i = 0;
        for (int index = firstArray.length - 1; index >= 0; index--) {
            i++;
            if (i == 1) {
                System.out.println(firstArray[index]);
            } else if (i == 2) {
                i = 0;
            }

        }


    }

}
