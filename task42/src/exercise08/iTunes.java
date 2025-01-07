package exercise08;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class iTunes {
    private static final String BASE_URL = "https://itunes.apple.com/search";

    public static ITunesProduct[] searchTracksByArtist(String artistName, int limit) throws Exception {
        String url = BASE_URL + "?term=" + artistName.replace(" ", "+") + "&entity=song&limit=10"; // Запрос на 50 треков
        String response = sendRequest(url);

        String[] rawTracks = extractArray(response, "results");
        ITunesProduct[] allTracks = new ITunesProduct[rawTracks.length];

        for (int i = 0; i < rawTracks.length; i++) {
            String rawTrack = rawTracks[i];
            String trackArtistName = extractField(rawTrack, "artistName");
            String trackName = extractField(rawTrack, "trackName");
            String collectionName = extractField(rawTrack, "collectionName");
            String releaseDate = extractField(rawTrack, "releaseDate");
            double trackPrice = 0.0;

            String priceString = extractFieldOptional(rawTrack, "trackPrice");
            if (priceString != null && !priceString.isEmpty()) {
                trackPrice = Double.parseDouble(priceString);
            }

            allTracks[i] = new ITunesProduct(trackArtistName, trackName, collectionName, trackPrice, releaseDate);
        }

        return selectRandomTracks(allTracks, limit);
    }

    private static ITunesProduct[] selectRandomTracks(ITunesProduct[] allTracks, int limit) {
        if (limit > allTracks.length) {
            throw new IllegalArgumentException("Лимит превышает количество доступных треков.");
        }

        Random random = new Random();
        ITunesProduct[] selectedTracks = new ITunesProduct[limit];
        boolean[] usedIndexes = new boolean[allTracks.length];

        int selectedCount = 0;
        while (selectedCount < limit) {
            int randomIndex = random.nextInt(allTracks.length);
            if (!usedIndexes[randomIndex]) {
                selectedTracks[selectedCount] = allTracks[randomIndex];
                usedIndexes[randomIndex] = true;
                selectedCount++;
            }
        }

        return selectedTracks;
    }

    private static String sendRequest(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static String[] extractArray(String json, String arrayKey) {
        int arrayStart = json.indexOf("\"" + arrayKey + "\":[") + arrayKey.length() + 3;
        int arrayEnd = json.indexOf("]", arrayStart);
        String arrayContent = json.substring(arrayStart, arrayEnd);

        return arrayContent.split("(?<=\\}),");
    }

    private static String extractField(String json, String fieldKey) {
        String key = "\"" + fieldKey + "\":";
        int startIndex = json.indexOf(key) + key.length();

        if (startIndex < key.length()) {
            throw new IllegalArgumentException("Поле " + fieldKey + " не найдено.");
        }

        if (json.charAt(startIndex) == '"') {
            int endIndex = json.indexOf("\"", startIndex + 1);
            return json.substring(startIndex + 1, endIndex);
        } else {
            int endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = json.indexOf("}", startIndex);
            }
            return json.substring(startIndex, endIndex);
        }
    }

    private static String extractFieldOptional(String json, String fieldKey) {
        if (!json.contains("\"" + fieldKey + "\":")) {
            return null;
        }
        return extractField(json, fieldKey);
    }
}
