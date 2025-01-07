package exercise08;

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
}