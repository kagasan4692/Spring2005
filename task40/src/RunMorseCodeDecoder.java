import java.util.Scanner;

public class RunMorseCodeDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Decoder decoder = new MorseCodeDecoder();

        String encoded;
        String decoded;

        System.out.print("Введите текст сообщения латинскими буквами: ");
        String sourceEn = scanner.nextLine();
        encoded = decoder.encode(sourceEn);
        System.out.println("Вывод: " + encoded);

        System.out.print("Введите текст сообщения кодом Морзе: ");
        String sourceMorse = scanner.nextLine();
        decoded = decoder.decode(sourceMorse);
        System.out.println("Вывод: " + decoded);
    }
}
