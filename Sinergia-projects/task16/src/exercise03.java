import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое слово маленькими буквами: ");
        String word = scanner.nextLine();

        int i = 0;
        char letter;

        do {
            letter = word.charAt(i);
            i++;
        } while (!isVowelLetter(letter) && i < word.length());

        if (isVowelLetter(letter)) {
            System.out.println("Первая гласная буква в слове : " + letter);
        } else {
            System.out.println("Эта строка не содержит гласных");
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
