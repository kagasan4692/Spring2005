public class RunExercise04 {
    public static void main(String[] args) {
        SongLyrics songLyrics = new ApiSongLyrics();

        String[] songsArray = {
                "Eminem - Lose Yourself",
                "Adele - Hello",
                "Unknown - Song",
                "Billy Joel - Honesty"
        };

        for (int i = 0; i < songsArray.length; i++) {
            System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(songsArray[i])));
        }
    }
}
