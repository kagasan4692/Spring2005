import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) throws IOException {

        String date = getEnteredDate();
        String dateDown = getDownDate(date);
        String dateUp = getUpDate(date);

        printInfo(dateDown);
        printInfo(date);
        printInfo(dateUp);

        printAnalytics(dateDown, date, dateUp);

    }

    private static void printInfo(String data) throws IOException {
        String value = usdValue(data);
        System.out.println("Курс доллара составляет на дату: " + data + " составляет : " + value);
    }

    private static String getEnteredDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd.mm.yyyy или dd/mm/yyyy"); // Поскольку в пройденном модуле работа с классом Data() не встречалась
        System.out.println("Вводить нужно даты в интервале между 2-м и 27 числом месяца "); // то я ввел ограничения в ввод дат!

        String date = scanner.nextLine();

        return date;
    }

    private static String getDownDate(String date) {
        int dayEntered = Integer.parseInt(date.substring(0, 2));
        int dayDown = dayEntered - 1;
        String dateDown = dateString(dayDown, date);

        return dateDown;
    }

    private static String getUpDate(String date) {
        int dayEntered = Integer.parseInt(date.substring(0, 2));
        int dayUp = dayEntered + 1;
        String dateUp = dateString(dayUp, date);

        return dateUp;
    }

    private static String lessValue(Double minValue) {

        return "Наименьшее значение курса доллара : " + Double.toString(minValue).replace('.', ',');
    }

    private static String moreValue(Double maxValue) {

        return "Наибольшее значение курса доллара : " + Double.toString(maxValue).replace('.', ',');
    }

    private static void printAnalytics(String dateDown, String date, String dateUp) throws IOException{
        double double1 = Double.parseDouble(usdValue(dateDown).replace(',', '.'));
        double double3 = Double.parseDouble(usdValue(dateUp).replace(',', '.'));
        double deltaValue = double1 - double3;

        double minValue = getMinValue(usdValue(dateDown), usdValue(date), usdValue(dateUp));

        double maxValue = getMaxValue(usdValue(dateDown), usdValue(date), usdValue(dateUp));

        if (deltaValue < 0) {
            System.out.println("Курс доллара вырос на " + String.format("%.4f", Math.abs(deltaValue)) + " руб");
            System.out.println(lessValue(minValue));
            System.out.println(moreValue(maxValue));
        } else if (deltaValue > 0) {
            System.out.println("Курс доллара упал на " + String.format("%.4f", Math.abs(deltaValue))  + " руб");
            System.out.println(lessValue(minValue));
            System.out.println(moreValue(maxValue));
        } else {
            System.out.println("Курс доллара не изменился");
        }

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

}
