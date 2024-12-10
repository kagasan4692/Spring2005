import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое слово : ");
        String word = scanner.nextLine();

        char[] wordArray = word.toCharArray();

        for (int i = wordArray.length - 1; i >= 0; i--) {
            System.out.println(wordArray[i]);
        }
    }
}
