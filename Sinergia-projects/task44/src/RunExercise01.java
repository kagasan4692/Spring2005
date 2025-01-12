public class RunExercise01 {
    public static void main(String[] args) {
        SongLyrics songLyrics = new LocalSongLyrics();

        String[] songsArray = {"Imagine", "Yesterday", "Unknown"};

        for (int i = 0; i < songsArray.length; i++) {
            System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(songsArray[i])));
        }
    }
}
