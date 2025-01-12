import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiSongLyrics extends SongLyrics {
    @Override
    public String getLyrics(String songTitle) {
        String[] parts = songTitle.split(" - ", 2); // Разделяем название на "артист - песня"
        if (parts.length != 2) {
            return "Invalid input format. Use 'Artist - Song Title'.";
        }

        String artist = parts[0].trim().replace(" ", "%20");
        String title = parts[1].trim().replace(" ", "%20");

        String apiUrl = "https://api.lyrics.ovh/v1/" + artist + "/" + title;
        System.out.println(apiUrl);

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return "Lyrics not found. HTTP Response Code: " + responseCode;
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            String jsonResponse = response.toString();
            int startIndex = jsonResponse.indexOf("\"lyrics\":\"") + 10;
            int endIndex = jsonResponse.indexOf("\"", startIndex);
            if (startIndex < 10 || endIndex < 0) {
                return "Lyrics not found in the response.";
            }

            String lyrics = jsonResponse.substring(startIndex, endIndex);
            return lyrics.replace("\\n", "\n").replace("\\\"", "\"");
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
