public class RunExercise02 {
    public static void main(String[] args) {
        String filePath = "songs.txt";
        SongLyrics songLyrics = new FileSongLyrics(filePath);

        String song1 = "Сибирские морозы";
        String song2 = "Анастасия";
        String song3 = "Лучший город земли";

        System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(song1)));
        System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(song2)));
        System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(song3)));
    }
}
