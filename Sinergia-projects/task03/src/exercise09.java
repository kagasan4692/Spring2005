import java.util.Scanner;

public class exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите слово больше 5 букв:");
        String str = scanner.nextLine();
        System.out.println(str.substring(0, 5));

    }
}
