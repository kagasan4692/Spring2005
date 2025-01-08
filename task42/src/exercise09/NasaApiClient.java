package exercise09;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NasaApiClient {
    private static final String API_KEY = "D6q5GOfTwbkkYfdnHZXgmRoIlNstZxbyxqUkHDBh"; // Используйте свой API-ключ здесь
    private static final String NASA_APOD_URL = "https://api.nasa.gov/planetary/apod";

    public static String getPictureOfTheDayJson() throws IOException, InterruptedException {
        String requestUrl = NASA_APOD_URL + "?api_key=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static NasaPictureInfo parsePictureOfTheDay(String jsonResponse) {
        String title = extractField(jsonResponse, "title");
        String url = extractField(jsonResponse, "url");
        String date = extractField(jsonResponse, "date");
        String explanation = extractField(jsonResponse, "explanation");
        String mediaType = extractField(jsonResponse, "media_type");
        String copyright = extractFieldOptional(jsonResponse, "copyright");

        return new NasaPictureInfo(title, url, date, explanation, mediaType, copyright);
    }

    private static String extractField(String json, String fieldName) {
        String key = "\"" + fieldName + "\":";
        int startIndex = json.indexOf(key) + key.length();

        if (startIndex < key.length()) {
            throw new IllegalArgumentException("Field " + fieldName + " not found.");
        }

        if (json.charAt(startIndex) == '"') {
            int endIndex = json.indexOf("\"", startIndex + 1);
            return json.substring(startIndex + 1, endIndex);
        } else {
            int endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = json.indexOf("}", startIndex);
            }
            return json.substring(startIndex, endIndex).trim();
        }
    }

    private static String extractFieldOptional(String json, String fieldName) {
        if (!json.contains("\"" + fieldName + "\":")) {
            return null;
        }
        return extractField(json, fieldName);
    }
}
