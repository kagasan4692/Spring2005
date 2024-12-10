import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {


        char[] firstArray = new char[5];

        int secondArrayLength;
        int i = 0;
        boolean isBreak = false;
        do {
            System.out.println("Введите любую букву :");
            Scanner scanner = new Scanner(System.in);
            String letter = scanner.nextLine();

            firstArray[i] = letter.charAt(0);

            if (letter.equals("ю") || i == firstArray.length - 1) {
                isBreak = true;

            }
            i++;
            secondArrayLength = i;
        } while (!isBreak);

        char[] secondArray = new char[secondArrayLength];

        for (int j = 0; j < secondArray.length; j++) {
            secondArray[j] = firstArray[j];
        }

    }
}
