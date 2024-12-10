import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise07 {
    public static void main(String[] args) throws IOException {
        int i = 0;
        while (i < 31) {
            i++;
            boolean isEarth = getPicture(dateJanuary2023(i));
            if (isEarth) {
                System.out.println("Найдено слово Earth в описании");
                break;
            }
        }
        System.out.println("Программа завершена!");
    }

    private static boolean getPicture(String date) throws IOException {
        String linkToPicture = pictureLinkNasaRequest(date)[0];
        boolean isEarth = Boolean.valueOf(pictureLinkNasaRequest(date)[1]);

        if (linkToPicture.equals("no image")) {
            System.out.println(date + ": Нет фотографии!");
        } else {

            try (InputStream in = new URL(linkToPicture).openStream()) {
                Files.copy(in, Path.of("nasa_pictures/picture_NASA" + "_" + formatDateForLink(date) + typeFile(linkToPicture)));
            }
            System.out.println(date + ": Фотография сохранена!");
        }

        return isEarth;
    }

    private static String dateJanuary2023(int numberDay) {
        String monthYear = ".01.2019";

        String dayDate = numberDay + monthYear;
        if (numberDay < 10) {
            dayDate = "0" + dayDate;
        }
        System.out.println(dayDate);
        return dayDate;
    }

    private static String formatDateForLink(String date) {

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

    private static String[] pictureLinkNasaRequest(String date) throws IOException {
        String dateForLink = "&date=" + formatDateForLink(date) + "&";
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?" + dateForLink + "api_key=D6q5GOfTwbkkYfdnHZXgmRoIlNstZxbyxqUkHDBh");

        int quoteExplanationStart = page.lastIndexOf("explanation") + 14;
        int quoteExplanationEnd = page.lastIndexOf("hdurl") - 3;
        String explanation = page.substring(quoteExplanationStart, quoteExplanationEnd);
        boolean isEarth = isEarthExplanation(explanation);
        String isEarthStr = String.valueOf(isEarth);

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

        String[] resultArray = new String[2];
        resultArray[0] = result;
        resultArray[1] = isEarthStr;

        return resultArray;
    }

    private static boolean isEarthExplanation(String text) {
        String word = "Earth";
        boolean isEarth;
        int index = text.indexOf(word);

        isEarth = index != -1 ? true : false;

        return isEarth;
    }

    private static String typeFile(String linkToPicture) {
        String tailLink = linkToPicture.substring(22);
        int typeFileStart = tailLink.lastIndexOf('.');

        return tailLink.substring(typeFileStart);
    }
}
