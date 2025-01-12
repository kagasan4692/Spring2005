import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DirectorySongLyrics extends SongLyrics {
    private final String directoryPath;

    public DirectorySongLyrics(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public String getLyrics(String songTitle) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            return "Directory does not exist or is not a valid directory.";
        }

        File[] files = directory.listFiles((dir, name) -> name.equalsIgnoreCase(songTitle + ".txt"));
        if (files == null || files.length == 0) {
            return "Lyrics not found.";
        }

        File songFile = files[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(songFile))) {
            StringBuilder lyrics = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                lyrics.append(line).append("\n");
            }
            return lyrics.toString().trim();
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}
