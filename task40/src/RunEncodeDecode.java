import java.util.Scanner;

public class RunEncodeDecode {


    public static void main(String[] args) {
        Decoder decoder = new RussianToLatinDecoder();

        String encoded;
        String decoded;

        System.out.println("Пример: ");
        System.out.print("Ввод: ");
        String sourceRu = "Привет, как дела?";
        System.out.println(sourceRu);
        encoded = decoder.encode(sourceRu);
        System.out.println("Вывод: " + encoded);

        System.out.print("Ввод: ");
        String sourceEn = "dobr-y den', kak deliwki?";
        System.out.println(sourceEn);
        decoded = decoder.decode(sourceEn);
        System.out.println("Вывод: " + decoded);

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
