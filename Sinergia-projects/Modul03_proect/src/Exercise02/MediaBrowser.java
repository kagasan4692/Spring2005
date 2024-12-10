package Exercise02;


import java.io.IOException;
import java.util.Scanner;

public class MediaBrowser {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для поиска трека:");
        String quote = scanner.nextLine();
        System.out.println("Идет поиск....");
        System.out.println();

        ITunesPlayList player = new ITunesPlayList();
        player.playList(quote);
    }
}
