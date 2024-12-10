import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class point01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd.mm.yyyy или dd/mm/yyyy"); // Поскольку в пройденном модуле работа с классом Data() не встречалась
        System.out.println("Вводить нужно даты в интервале между 2-м и 27 числом месяца "); // то я ввел ограничения в ввод дат!

        String date = scanner.nextLine();

        int dayEntered = Integer.parseInt(date.substring(0, 2));

        int dayDown = dayEntered - 1;
        int dayUp = dayEntered + 1;

        String dateDown = dateString(dayDown, date);
        String valueDown = usdValue(dateDown);

        System.out.println("Курс доллара составляет на дату: " + dateDown + " составляет : " + valueDown);

        String dateEntered = dateString(dayEntered, date);
        String value = usdValue(date);

        System.out.println("Курс доллара составляет на дату: " + dateEntered + " составляет : " + value);

        String dateUp = dateString(dayUp, date);
        String valueUp = usdValue(dateUp);

        System.out.println("Курс доллара составляет на дату: " + dateUp + " составляет : " + valueUp);

        double minValue = getMinValue(valueDown, value, valueUp);
        double maxValue = getMaxValue(valueDown, value, valueUp);

        double deltaValue = deltaValue(valueDown, valueUp);

        if (deltaValue < 0) {
            System.out.println("Курс доллара вырос на " + Math.abs(deltaValue) + " руб");
            System.out.println(lessValue(minValue));
            System.out.println(moreValue(maxValue));
        } else if (deltaValue > 0) {
            System.out.println("Курс доллара упал на " + Math.abs(deltaValue) + " руб");
            System.out.println(lessValue(minValue));
            System.out.println(moreValue(maxValue));
        } else {
            System.out.println("Курс доллара не изменился");
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Делаем запрос на получение лучшей фотографии NASA на дату : " + date);
        System.out.println("Пожалуйста, подождите...");

        String linkToPicture = pictureLinkNasaRequest(date);

        System.out.println(linkToPicture);

        if (linkToPicture.equals("no image")) {
            System.out.println("Данная ссылка не содержит фотографии!");
        } else {
            System.out.println("Ссылка получена");
            System.out.println("Получаем фотографию...");

            try (InputStream in = new URL(linkToPicture).openStream()) {
                Files.copy(in, Path.of("nasa_pictures/best_picture_NASA" + "_" + formatDateForLink(date) + typeFile(linkToPicture)));
            }
            System.out.println("Фотография получена!");
        }

    }

    private static String typeFile(String linkToPicture) { // Ссылки на фотки имеют разные расширения. Например .jpg, .gif ...
        String tailLink = linkToPicture.substring(22);
        int typeFileStart = tailLink.lastIndexOf('.');

        return tailLink.substring(typeFileStart);
    }

    private static String lessValue(Double minValue) {

        return "Наименьшее значение курса доллара : " + Double.toString(minValue).replace('.', ',');
    }

    private static String moreValue(Double maxValue) {

        return "Наибольшее значение курса доллара : " + Double.toString(maxValue).replace('.', ',');
    }

    private static Double deltaValue(String value1, String value3) {
        double double1 = Double.parseDouble(value1.replace(',', '.'));
        double double3 = Double.parseDouble(value3.replace(',', '.'));

        return double1 - double3;
    }


    private static Double getMinValue(String value1, String value2, String value3) {
        double double1 = Double.parseDouble(value1.replace(',', '.'));
        double double2 = Double.parseDouble(value2.replace(',', '.'));
        double double3 = Double.parseDouble(value3.replace(',', '.'));

        double min = Math.min(double1, double2);
        min = Math.min(min, double3);

        return min;
    }

    private static Double getMaxValue(String value1, String value2, String value3) {
        double double1 = Double.parseDouble(value1.replace(',', '.'));
        double double2 = Double.parseDouble(value2.replace(',', '.'));
        double double3 = Double.parseDouble(value3.replace(',', '.'));

        double max = Math.max(double1, double2);
        max = Math.max(max, double3);

        return max;
    }

    private static String dateString(int numberDay, String date) {
        String monthYear = date.substring(2, 10);

        String dayDate = numberDay + monthYear;
        if (numberDay < 10) {
            dayDate = "0" + dayDate;
        }

        return dayDate;
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

    private static String usdQuoteSbrRequest(String date) throws IOException {
        String page = downloadWebPage("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);

        int quoteStart = page.lastIndexOf("R01235") + 40;
        int quoteEnd = quoteStart + 109;

        return page.substring(quoteStart, quoteEnd);
    }

    private static String usdValue(String date) throws IOException {
        String StringUsdValue = usdQuoteSbrRequest(date);

        int substringStart = StringUsdValue.lastIndexOf("<Value>") + 7;
        int substringEnd = StringUsdValue.lastIndexOf("</Value>");

        return StringUsdValue.substring(substringStart, substringEnd);
    }

    private static String formatDateForLink(String date) throws IOException {

        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));

        return year + "-" + month + "-" + day;
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
}
