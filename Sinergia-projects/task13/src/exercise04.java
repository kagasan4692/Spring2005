import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите любую строку");
        String string = scanner.nextLine();

        int i = 0;
        do {
            System.out.print(string.charAt(i));

            if (string.charAt(i) == ' ') {
                System.out.println();
            }

            i++;
        } while (i < string.length());
    }
}
