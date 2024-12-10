import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите более 3-х слов:");
        String string = scanner.nextLine();

        int i = 0, j = 0;

        do {
            System.out.print(string.charAt(i));

            if (string.charAt(i) == ' ') {
                System.out.println();
                j++;
            }

            i++;
        } while (j < 3);
    }
}
