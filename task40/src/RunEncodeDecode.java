import java.util.Scanner;

public class RunEncodeDecode {
    public static void main(String[] args) {
        Decoder decoder = new RussianToLatinDecoder();

        System.out.println("Пример: ");
        String sourceRu = "Привет, как дела?";
        String encoded = decoder.encode(sourceRu);
        System.out.println("Encoded: " + encoded);

        String sourceEn = "Dobr_y den', kak dela?";
        String decoded = decoder.decode(sourceEn);
        System.out.println("Decoded: " + decoded);

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите русскими буквами слово, которое нужно перекодировать!");

        String ru = scanner.nextLine();
        encoded = decoder.encode(ru);
        System.out.println("Encoded: " + encoded);

        System.out.println("введите латинскими буквами слово, которое нужно перекодировать!");

        String en = scanner.nextLine();
        decoded = decoder.decode(en);
        System.out.println("Decoded: " + decoded);

    }
}
