import java.io.IOException;
import java.util.Scanner;

public class exercise09 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean isTrue = false;
        do {
            System.out.println("Введите цифру от 0 до 9:");
            int numberInt = scanner.nextInt();

            if (numberInt >= 0 && numberInt <= 6) {
                isTrue = true;
            } else if (numberInt == 7 || numberInt == 8) {
                Scanner scannerStr = new Scanner(System.in);
                System.out.println("Введите секретное слово:");

                String secretWord = scannerStr.nextLine();

                if (secretWord.equals("СТОП")) {
                    isTrue = false;
                } else {
                    isTrue = true;
                }
            } else if (numberInt == 9) {
                isTrue = false;
            }
        } while (isTrue);

        System.out.println("КОНЕЦ");
    }
}
