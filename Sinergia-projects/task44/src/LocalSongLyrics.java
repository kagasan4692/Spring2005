public class LocalSongLyrics extends SongLyrics {
    private String[] songTitles = {"Imagine", "Yesterday", "Let It Be"};
    private String[] songLyrics = {
            "Imagine all the people...",
            "Yesterday, all my troubles seemed so far away...",
            "When I find myself in times of trouble..."
    };

    @Override
    public String getLyrics(String songTitle) {

        for (int i = 0; i < songTitles.length; i++) {
            if (songTitles[i].equalsIgnoreCase(songTitle)) {
                return songLyrics[i];
            }
        }

        return "Lyrics not found.";
    }
}
