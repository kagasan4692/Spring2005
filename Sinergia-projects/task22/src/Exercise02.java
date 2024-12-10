import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слова!");
        int length = 3;

        String[] wordsArray = new String[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Введите словo № " + (i + 1));
            wordsArray[i] = scanner.nextLine();
        }

        StringBuilder words = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            words.append(wordsArray[i] + " ");
        }

        String reversedString = words.toString();

        System.out.println(reversedString);
    }


}