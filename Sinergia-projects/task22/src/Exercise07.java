import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите предложение из двух слов: ");
        String input = scanner.nextLine();

        StringBuilder string = new StringBuilder(input);
        String input1 = input;
        int index;
        int i = 0;
        do {
            index = input1.lastIndexOf(' ');
            if (index != -1) {
                string.deleteCharAt(index);
                input1 = string.toString();
            }
            i++;

        } while (index != -1);


        System.out.println(string);

    }
}
