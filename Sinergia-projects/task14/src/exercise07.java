import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Игрок №1 введи слово :");
        String word = scanner.nextLine();

        char[] firstArray = new char[word.length()];
        char[] tableArray = new char[word.length()];

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = word.charAt(i);
            tableArray[i] = '#';
            System.out.print('#');
        }

        boolean isTrue;
        do {
            isTrue = false;
            System.out.println();
            System.out.println("Игрок №2 введи букву :");

            String letter = scanner.nextLine();
            char letterChar = letter.charAt(0);

            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i] == letterChar) {
                    tableArray[i] = firstArray[i];
                }

            }

            for (int i = 0; i < tableArray.length; i++) {
                System.out.print(tableArray[i]);
                if (tableArray[i] == '#') {
                    isTrue = true;
                }

            }
        } while (isTrue);

        System.out.println();
        System.out.println("Игрок угадал слово!");
    }
}
