import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WordCounter {
    private String filePath;

    public WordCounter() {
        this.filePath = "text_song.txt";
    }

    public WordCounter(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> getListWords() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        String[] wordsArray = content.trim().split("\\s+");

        ArrayList<String> wordsList = new ArrayList<>();
        for (String word : wordsArray) {
            wordsList.add(word);
        }

        return wordsList;
    }
}
