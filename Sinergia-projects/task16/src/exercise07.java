import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число :");
        String word = scanner.nextLine();

        char[] wordArray = word.toCharArray();

        int fractionalPartStart = 0;
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == '.' || wordArray[i] == ',') {
                fractionalPartStart = i;
            }
        }

        int lengthFractionalPart = wordArray.length - 1 - fractionalPartStart;
        char[] fractionalPart = new char[lengthFractionalPart];

        int j = 0;
        for (int i = fractionalPartStart + 1; i < wordArray.length; i++) {
            fractionalPart[j] = wordArray[i];
            j++;
        }

        System.out.print("Дробная часть числа : ");

        for (int i = 0; i < fractionalPart.length; i++) {
            System.out.print(fractionalPart[i]);
        }
    }
}
