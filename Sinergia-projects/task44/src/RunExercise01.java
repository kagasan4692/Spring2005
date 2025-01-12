public class RunExercise01 {
    public static void main(String[] args) {
        SongLyrics songLyrics = new LocalSongLyrics();

        String song1 = "Imagine";
        String song2 = "Yesterday";
        String song3 = "Unknown";

        System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(song1)));
        System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(song2)));
        System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(song3)));
    }
}
