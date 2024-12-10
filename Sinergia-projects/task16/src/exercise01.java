import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantityString = 5;
        char[] firstLetters = new char[quantityString];

        for (int i = 0; i < firstLetters.length; i++) {
            System.out.println("Введите строку номер " + (i + 1));
            firstLetters[i] = scanner.nextLine().charAt(0);
        }

        for (int i = 0; i < firstLetters.length; i++) {
            System.out.print(firstLetters[i]);
        }

    }
}
