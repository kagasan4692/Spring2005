import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) throws IOException {
        String firstPath = "playerFiles/firstFile.txt";
        String firstPlayer = "1-й";

        String secondPath = "playerFiles/secondFile.txt";
        String secondPlayer = "2-й";

        writingToFile(firstPath, firstPlayer);
        writingToFile(secondPath, secondPlayer);

        System.out.println("СТАРТ ИГРЫ");
        System.out.println(" ");

        int i = 0;

        boolean first = false;
        boolean second = false;

        while (!(first || second)) {
            i++;
            System.out.println("РАУНД № " + i);

            first = riddle(firstPath, firstPlayer);
            second = riddle(secondPath, secondPlayer);
        }

        if (first && second) {
            System.out.println("Ничья");

        } else if (first && !second) {
            System.out.println("Победил " + firstPlayer + " игрок");

        } else if (!first && second) {
            System.out.println("Победил " + secondPlayer + " игрок");

        }

        System.out.println(" ");
        System.out.println("КОНЕЦ ИГРЫ");

    }

    private static void writingToFile(String path, String player) throws IOException {

        Scanner scanner = new Scanner(System.in);

        PrintWriter streamPlayer = new PrintWriter(path);

        System.out.println(player + " игрок введи текст подсказки:");
        String hint = scanner.nextLine();

        System.out.println(player + " игрок введи слово - ответ:");
        String answer = scanner.nextLine();

        streamPlayer.println(hint);
        streamPlayer.println(answer);
        streamPlayer.close();

        System.out.println(" ");
    }

    private static Boolean riddle(String path, String player) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();
        System.out.println(line);
        String line1 = reader.readLine();


        System.out.println(player + " игрок Введите слово - ответ:");
        String answer = scanner.nextLine();

        boolean isTrue;
        if (answer.equals(line1)) {
            System.out.println("Ответ правильный!");
            System.out.println(" ");

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
