import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите любую строку");
        String string = scanner.nextLine();

        System.out.println(string.charAt(1));
    }
}
