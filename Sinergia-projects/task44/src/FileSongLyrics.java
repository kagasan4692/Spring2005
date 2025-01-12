import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileSongLyrics extends SongLyrics {
    private final String filePath;

    public FileSongLyrics(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getLyrics(String songTitle) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder lyrics = new StringBuilder();
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (found) {
                        return lyrics.toString();
                    }
                    lyrics.setLength(0);
                    found = false;
                } else if (!found && line.startsWith(songTitle + ":")) {
                    found = true;
                    lyrics.append(line.substring((songTitle + ":").length()).trim());
                } else if (found) {
                    lyrics.append("\n").append(line.trim());
                }
            }

            if (found) {
                return lyrics.toString();
            }

        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }

        return "Lyrics not found.";
    }
}
