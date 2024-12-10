import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("введите первое слово");
        String word1 = scanner.nextLine();

        System.out.println("введите второе слово");
        String word2 = scanner.nextLine();

        System.out.println("введите третье слово");
        String word3 = scanner.nextLine();

        System.out.println(word3);
        System.out.println(word2);
        System.out.println(word1);
    }
}
