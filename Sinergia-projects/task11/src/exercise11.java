import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class exercise11 {
    public static void main(String[] args) throws IOException{
        int i = 0;
        while (i < 31) {
            i++;
            getPicture(dateJanuary2022(i));
        }
    }

    private static void getPicture(String date) throws IOException{
        String linkToPicture = pictureLinkNasaRequest(date);

        if (linkToPicture.equals("no image")) {
            System.out.println(date + ": Нет фотографии!");
        } else {

            try (InputStream in = new URL(linkToPicture).openStream()) {
                Files.copy(in, Path.of("nasa_pictures/picture_NASA" + "_" + formatDateForLink(date) + typeFile(linkToPicture)));
            }
            System.out.println(date + ": Фотография сохранена!");
        }
    }

    private static String dateJanuary2022(int numberDay) {
        String monthYear = ".01.2022";

        String dayDate = numberDay + monthYear;
        if (numberDay < 10) {
            dayDate = "0" + dayDate;
        }

        return dayDate;
    }

    private static String formatDateForLink(String date){

        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));

        return year + "-" + month + "-" + day;
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

    private static String pictureLinkNasaRequest(String date) throws IOException {
        String dateForLink = "&date=" + formatDateForLink(date) + "&";
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?" + dateForLink + "api_key=DEMO_KEY");

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

}
