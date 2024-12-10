import java.util.Scanner;

public class exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        boolean isContains = false;
        while (!isContains) {
            i++;
            System.out.println("Введите в любую строку №" + i);

            String newString = scanner.nextLine();
            System.out.println(newString.substring(0, 1));
            if (newString.contains(" ")) {
                isContains = true;
                System.out.println("Вы ввели пробел!");
            }
        }

        System.out.println("Конец программы!");


    }
}
