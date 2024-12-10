import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое слово:");
        String str1 = scanner.nextLine();

        System.out.println("Введите второе слово:");
        String str2 = scanner.nextLine();

        int sumLengths = str1.length() + str2.length();

        System.out.println("Всего Вы ввели: " + sumLengths + " символа(ов)");

    }
}
