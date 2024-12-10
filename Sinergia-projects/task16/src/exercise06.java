import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое слово маленькими буквами : ");
        String word = scanner.nextLine();

        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            if (isVowelLetter(wordArray[i])) {
                wordArray[i] = 'у';
            }
        }

        for (int i = 0; i < wordArray.length; i++) {
            System.out.print(wordArray[i]);
        }
    }

    private static boolean isVowelLetter(char letter) {
        char[] lettersArray = {'а', 'о', 'э', 'е', 'и', 'ы', 'у', 'ё', 'ю', 'я'};

        boolean isTrue = false;
        for (int i = 0; i < lettersArray.length; i++) {
            if (letter == lettersArray[i]) {
                isTrue = true;
            }
        }

        return isTrue;
    }
}
