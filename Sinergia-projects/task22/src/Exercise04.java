import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слова!");
        int length = 5;

        StringBuilder words = new StringBuilder();
        for (int i = 0; i < length; i++) {
            System.out.println("Введите словo № " + (i + 1));
            if (i < length - 1) {
                words.append(scanner.nextLine() + ", и ");
            } else {
                words.append(scanner.nextLine() + "!");
            }

        }

        String newString = words.toString();

        System.out.println(newString);
    }
}
