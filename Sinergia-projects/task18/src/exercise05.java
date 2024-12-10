import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class exercise05 {
    public static void main(String[] args) throws IOException {
        String filePath = "picture_NASA_of_day.jpg";

        savePictureToFile(filePath);

        // для сохранения файла в класс нудно запустить класс: myClassForSaveFotoNasa
    }

    private static String pictureLinkNasaRequest() throws IOException {
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

        int quoteStart = page.lastIndexOf("url") + 6;
        int quoteEnd = page.lastIndexOf('}') - 1;
        String link = page.substring(quoteStart, quoteEnd);

        return link;
    }

    private static void savePictureToFile(String filePath) throws IOException {
        String linkToPicture = pictureLinkNasaRequest();
        try (InputStream in = new URL(linkToPicture).openStream()) {
            Files.copy(in, Path.of(filePath));
        }
        System.out.println("Фотография сохранена в файл!");
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

}
