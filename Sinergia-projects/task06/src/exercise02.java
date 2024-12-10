import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите любую строку:");
        String string = scanner.nextLine();


        if (string.contains(" ")) {
            System.out.println("Вы ввели больше одного слова");
        } else {
            System.out.println("Вы ввели только одно слово");
        }

    }
}
