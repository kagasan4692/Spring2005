import java.io.File;
import java.util.Scanner;

public class exercise10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isExists = false;
        while (!isExists) {
            System.out.println("Введите полный путь к файлу (например: C:/java-examples/example.txt):");
            String fullPath = scanner.nextLine();

            File file = new File(fullPath);
            if (file.exists()) {
                isExists = true;
                System.out.println("Вы ввели верный путь!");
            } else {
                System.out.println("Вы ввели не верный путь!");
            }

        }

        System.out.println("КОНЕЦ ПРОГРАММЫ");

    }
}
