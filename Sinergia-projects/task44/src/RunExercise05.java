import java.util.Scanner;

public class RunExercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите источник для поиска текстов песен:");
        System.out.println("1. Файл \"songs.txt\"");
        System.out.println("2. Папка \"songs/...\"");
        System.out.println("3. API \"api.lyrics.ovh\"");
        int choice = scanner.nextInt();
        scanner.nextLine();

        SongLyrics songLyrics = null;
        String artist = "";

        switch (choice) {
            case 1:
                songLyrics = new FileSongLyrics("songs.txt");
                break;
            case 2:
                songLyrics = new DirectorySongLyrics("songs");
                break;
            case 3:
                songLyrics = new ApiSongLyrics();
                System.out.print("Введите имя артиста: ");
                artist = scanner.nextLine();
                break;
            default:
                System.out.println("Неверный выбор. Завершение программы.");
                return;
        }

        System.out.print("Введите название песни: ");
        String song = scanner.nextLine();

        printLyrics(artist, song, songLyrics);
    }

    public static void printLyrics(String artist, String song, SongLyrics songLyrics) {
        String lyrics;
        if (artist.equals("")){
            lyrics = songLyrics.getLyrics(song);
        } else {
            String songTitle = artist + " - " + song;
            lyrics = songLyrics.getLyrics(songTitle);
        }
        System.out.println(songLyrics.formatLyrics(lyrics));
    }
}
