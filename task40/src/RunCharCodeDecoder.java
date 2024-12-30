import java.util.Scanner;

public class RunCharCodeDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encoded;
        String decoded;

        Decoder decoder = new CharCodeDecoder();

        System.out.println("Введите слово: ");

        String ru = scanner.nextLine();
        encoded = decoder.encode(ru);
        System.out.println("Коды клавиш: " + encoded);

        System.out.println("введите коды символов клавиш через пробел: ");

        String ch = scanner.nextLine();
        decoded = decoder.decode(ch);
        System.out.println("Результат: " + decoded);
    }
}
