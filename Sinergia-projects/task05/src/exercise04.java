import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ведите первую строку");
        String string1 = scanner.nextLine();

        System.out.println("Ведите вторую строку");
        String string2 = scanner.nextLine();

        int result = Math.abs(string1.length() - string2.length());
        System.out.println("Разница по длине составляет:");
        System.out.println(result);
    }
}
