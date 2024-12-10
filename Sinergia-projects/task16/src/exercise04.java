import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое слово маленькими буквами : ");
        String word = scanner.nextLine();

        int counter = 0;
        char letter;
        for (int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);

            if (isVowelLetter(letter)) {
                counter++;
            }
        }
        System.out.println("В слове " + '"' + word + '"' + " " + counter + " гласных");
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
