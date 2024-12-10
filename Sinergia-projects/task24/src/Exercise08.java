import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Exercise08 {
    private static final String apiKey = "D6q5GOfTwbkkYfdnHZXgmRoIlNstZxbyxqUkHDBh";

    public static void main(String[] args) throws IOException {
        LocalDate startDate = LocalDate.of(2023, 11, 1);
        LocalDate endDate = LocalDate.of(2023, 11, 5);

        requestImagesForDateRange(startDate, endDate);

    }

    public static void requestImagesForDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            try {
                String linkToImage = getNasaLinkToImage(date.toString());
                System.out.println("Получаем ссылку на дату: " + date);
                System.out.println(linkToImage);

                savePicture(date.toString(), linkToImage);

            } catch (Exception e) {
                System.out.println("Ошибка при сохранении снимка для даты " + date);
                System.out.println("---------------------------------------");
            }
            date = date.plusDays(1);
        }
    }

    private static void savePicture(String date, String linkToImage) throws IOException {

        if (linkToImage.equals("no image")) {
            System.out.println(date + ": Нет фотографии!");
        } else {

            try (InputStream in = new URL(linkToImage).openStream()) {
                Files.copy(in, Path.of("nasa_pictures/picture_NASA" + "_" + date + typeFile(linkToImage)));
            }
            System.out.println(date + ": Фотография сохранена!");
        }

        System.out.println("---------------------------------------");

    }

    public static String getNasaLinkToImage(String date) throws IOException {
        String dateForLink = "&date=" + date + "&";
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?" + dateForLink + "api_key=" + apiKey);

        int quoteMediaTypeStart = page.lastIndexOf("media_type") + 13;
        int quoteMediaTypeEnd = page.lastIndexOf("service_version") - 3;
        String mediaType = page.substring(quoteMediaTypeStart, quoteMediaTypeEnd);

        String result;
        if (mediaType.equals("image")) {
            int quoteStart = page.lastIndexOf("url") + 6;
            int quoteEnd = page.lastIndexOf("}") - 1;
            result = page.substring(quoteStart, quoteEnd);
        } else {
            result = "no image";
        }

        return result;
    }

    private static String typeFile(String linkToPicture) {
        String tailLink = linkToPicture.substring(22);
        int typeFileStart = tailLink.lastIndexOf('.');

        return tailLink.substring(typeFileStart);
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
