import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise07 {
    private static final String apiKey = "D6q5GOfTwbkkYfdnHZXgmRoIlNstZxbyxqUkHDBh";

    public static void main(String[] args) {
        getPicture("2020-02-02");
    }

    private static void getPicture(String date) {
        try {
            String linkToPicture = pictureLinkNasaRequest(date);

            if (linkToPicture.equals("no image")) {
                throw new Exception("Нет фотографии!");
            } else {

                try (InputStream in = new URL(linkToPicture).openStream()) {
                    Files.copy(in, Path.of("picture_NASA" + date + typeFile(linkToPicture)));
                }
                System.out.println(date + ": Фотография сохранена!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при получении фотографии для даты " + date + ": " + e.getMessage());
        }

    }

    private static String downloadWebPage(String url) {
        StringBuilder result = new StringBuilder();
        String line;
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            try (InputStream is = urlConnection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке веб-страницы: " + e.getMessage());
        }


        return result.toString();
    }

    private static String pictureLinkNasaRequest(String date) {
        try {
            String page = downloadWebPage("https://api.nasa.gov/planetary/apod?&date=" + date + "&api_key=" + apiKey);

            int quoteMediaTypeStart = page.lastIndexOf("media_type") + 13;
            if (page.lastIndexOf("media_type") == -1) {
                throw new Exception("Ключевое слово media_type не найдено");
            }
            int quoteMediaTypeEnd = page.lastIndexOf("service_version") - 3;
            String mediaType = page.substring(quoteMediaTypeStart, quoteMediaTypeEnd);

            if (mediaType.equals("image")) {
                int quoteStart = page.lastIndexOf("url") + 6;
                if (page.lastIndexOf("url") == -1) {
                    throw new Exception("Ключевое слово url не найдено");
                }
                int quoteEnd = page.lastIndexOf("}") - 1;
                return page.substring(quoteStart, quoteEnd);
            } else {
                return "no image";
            }
        } catch (Exception e) {
            System.out.println("Ошибка при запросе фотографии NASA: " + e.getMessage());
            return "no image";
        }
    }

    private static String typeFile(String linkToPicture) {
        String tailLink = linkToPicture.substring(22);
        int typeFileStart = tailLink.lastIndexOf('.');

        return tailLink.substring(typeFileStart);
    }
}
