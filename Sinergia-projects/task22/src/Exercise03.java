import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово :");

        String word = scanner.nextLine();

        StringBuilder answer = new StringBuilder();
        answer.append("ВЫ говорите: ");
        answer.append("... ");
        answer.append(word);
        answer.append(" ... и что?");

        String answerString = answer.toString();

        System.out.println(answerString);
    }
}
