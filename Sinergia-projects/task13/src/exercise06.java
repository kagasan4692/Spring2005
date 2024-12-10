import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите любую строку:");
        String string = scanner.nextLine();

        int i = string.length();

        do {
            i--;
            System.out.print(string.charAt(i));

        } while (i != 0);
    }
}
