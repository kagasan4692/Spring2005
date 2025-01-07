package exercise07;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ITunesProduct {
    private String artistName;
    private String trackName;
    private String collectionName;
    private double trackPrice;
    private String releaseDate;

    public ITunesProduct(String artistName, String trackName, String collectionName, double trackPrice, String releaseDate) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.collectionName = collectionName;
        this.trackPrice = trackPrice;
        this.releaseDate = releaseDate;
    }

    public static ITunesProduct getTrackByArtist(String artistName) throws Exception {
        String url = "https://itunes.apple.com/search?term=" + artistName.replace(" ", "+") + "&entity=song&limit=1";
        String response = makeITunesRequest(url);

        String[] rawTracks = extractArray(response, "results");
        if (rawTracks.length == 0) {
            throw new IllegalArgumentException("Нет треков для исполнителя: " + artistName);
        }

        String rawTrack = rawTracks[0]; // Берём первый найденный трек
        String trackArtistName = extractField(rawTrack, "artistName");
        String trackName = extractField(rawTrack, "trackName");
        String collectionName = extractField(rawTrack, "collectionName");
        String releaseDate = extractField(rawTrack, "releaseDate");
        double trackPrice = 0.0;

        String priceString = extractFieldOptional(rawTrack, "trackPrice");
        if (priceString != null && !priceString.isEmpty()) {
            trackPrice = Double.parseDouble(priceString);
        }

        return new ITunesProduct(trackArtistName, trackName, collectionName, trackPrice, releaseDate);
    }

    public static String makeITunesRequest(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String[] extractArray(String json, String arrayKey) {
        int arrayStart = json.indexOf("\"" + arrayKey + "\":[") + arrayKey.length() + 3;
        int arrayEnd = json.indexOf("]", arrayStart);
        String arrayContent = json.substring(arrayStart, arrayEnd);

        return arrayContent.split("(?<=\\}),");
    }

    public static String extractField(String json, String fieldKey) {
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

    public static String extractFieldOptional(String json, String fieldKey) {
        if (!json.contains("\"" + fieldKey + "\":")) {
            return null;
        }
        return extractField(json, fieldKey);
    }

    private String escapeJson(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"artist\": \"" + escapeJson(artistName) + "\",\n" +
                "  \"name\": \"" + escapeJson(trackName) + "\",\n" +
                "  \"album\": \"" + escapeJson(collectionName) + "\",\n" +
                "  \"price\": " + trackPrice + ",\n" +
                "  \"releaseDate\": \"" + escapeJson(releaseDate) + "\"\n" +
                "}";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ITunesProduct that = (ITunesProduct) obj;

        boolean artistAndTrackMatch = this.artistName.equals(that.trackName);
        boolean trackAndArtistMatch = this.trackName.equals(that.artistName);
        boolean artistMatch = this.artistName.equals(that.artistName);
        boolean trackMatch = this.trackName.equals(that.trackName);

        return artistAndTrackMatch || trackAndArtistMatch || artistMatch || trackMatch;
    }
}