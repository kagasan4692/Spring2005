
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите построчно четверостишее!");

        StringBuilder poem = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            System.out.println("Введите стороку № " + (i + 1));
            poem.append(scanner.nextLine() + "\n");
        }

        String stringPoem = poem.toString();

        System.out.println(stringPoem);
    }
}
