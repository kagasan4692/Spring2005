package exercise06;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ITunesSong {
    public static String outFormat;
    public static void run(String outFormat) {
        ITunesSong.outFormat = outFormat;
        try {
            ITunesSong[] tracks = getRandomTracks(10);

            System.out.println("=== Random Tracks from iTunes ===");
            for (int i = 0; i < tracks.length; i++) {
                System.out.println(tracks[i]);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    private String artistName;
    private String trackName;
    private String collectionName;
    private double trackPrice;
    private String releaseDate;

    public ITunesSong(String artistName, String trackName, String collectionName, double trackPrice, String releaseDate) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.collectionName = collectionName;
        this.trackPrice = trackPrice;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "<track>\n" +
                "  <artist>" + escapeXml(artistName) + "</artist>\n" +
                "  <name>" + escapeXml(trackName) + "</name>\n" +
                "  <album>" + escapeXml(collectionName) + "</album>\n" +
                "  <price>" + trackPrice + "</price>\n" +
                "  <releaseDate>" + escapeXml(releaseDate) + "</releaseDate>\n" +
                "</track>" + outFormat;
    }

    private String escapeXml(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    public static ITunesSong[] getRandomTracks(int count) throws Exception {
        String url = "https://itunes.apple.com/search?term=random&entity=song&limit=" + count;
        String response = makeITunesRequest(url);

        String[] rawTracks = extractArray(response, "results");
        ITunesSong[] tracks = new ITunesSong[rawTracks.length];

        for (int i = 0; i < rawTracks.length; i++) {
            String rawTrack = rawTracks[i];
            String artistName = extractField(rawTrack, "artistName");
            String trackName = extractField(rawTrack, "trackName");
            String collectionName = extractField(rawTrack, "collectionName");
            String releaseDate = extractField(rawTrack, "releaseDate");
            double trackPrice = 0.0;

            String priceString = extractFieldOptional(rawTrack, "trackPrice");
            if (priceString != null && !priceString.isEmpty()) {
                trackPrice = Double.parseDouble(priceString);
            }

            tracks[i] = new ITunesSong(artistName, trackName, collectionName, trackPrice, releaseDate);
        }

        return tracks;
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
}