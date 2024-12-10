import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение из двух слов: ");

        String phrase = scanner.nextLine();
        int spaceIndex = phrase.indexOf(" ");

        StringBuilder builderPhrase = new StringBuilder(phrase);
        builderPhrase.insert(spaceIndex, ", так сказать,");

        String stringPhrase = builderPhrase.toString();

        System.out.println(stringPhrase);
    }
}
