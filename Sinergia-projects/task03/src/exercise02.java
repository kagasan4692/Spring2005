import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите слово:");
        String str = scanner.nextLine();

        System.out.println("Вы ввели строку длиной " + str.length() + " символа(ов)");

    }
}