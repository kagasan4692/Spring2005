package exercise09;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NasaPictureInfo {
    private String title;
    private String url;
    private String date;
    private String explanation;
    private String mediaType;
    private String copyright;

    public NasaPictureInfo(String title, String url, String date, String explanation, String mediaType, String copyright) {
        this.title = title;
        this.url = url;
        this.date = date;
        this.explanation = explanation;
        this.mediaType = mediaType;
        this.copyright = copyright;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getCopyright() {
        return copyright;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "URL: " + url + "\n" +
                "Date: " + date + "\n" +
                "Explanation: " + explanation + "\n" +
                "Media Type: " + mediaType + "\n" +
                "Copyright: " + (copyright != null ? copyright : "Public Domain") + "\n";
    }

    public void downloadImage(String savePath) throws IOException {
        if (!mediaType.equals("image")) {
            throw new IllegalArgumentException("The media type is not an image. Media Type: " + mediaType);
        }

        URI imageUri = URI.create(url);
        Path targetPath = Path.of(savePath);

        Files.copy(imageUri.toURL().openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Image downloaded to: " + savePath);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NasaPictureInfo other = (NasaPictureInfo) obj;
        return this.toString().equals(other.toString());
    }
}
