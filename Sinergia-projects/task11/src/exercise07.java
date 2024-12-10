import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) throws IOException {
        int i = 1;
        while (!riddle()) {
            i++;
            System.out.println("Попытка № " + i);
        }

        System.out.println("Ответ правильный!");
    }

    private static Boolean riddle() throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new FileReader("riddle.txt"));

        String line = reader.readLine();
        System.out.println(line);
        String line1 = reader.readLine();


        System.out.println("Введите слово - ответ:");
        String answer = scanner.nextLine();

        boolean isTrue;
        if (answer.equals(line1)) {

            isTrue = true;

        } else {

            if (line1.contains(answer)) {
                System.out.println("не верно! Но ГОРЯЧО!");
                System.out.println(" ");
            } else {
                System.out.println("не верно!");
                System.out.println(" ");
            }

            isTrue = false;

        }

        reader.close();

        return isTrue;
    }
}
