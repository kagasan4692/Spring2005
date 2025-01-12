public abstract class SongLyrics {

    public abstract String getLyrics(String songTitle);

    public String formatLyrics(String lyrics) {
        if (lyrics == null || lyrics.isEmpty()) {
            return "Lyrics not found.";
        }
        return "\n************\nSong Lyrics:\n" + lyrics;
    }
}
