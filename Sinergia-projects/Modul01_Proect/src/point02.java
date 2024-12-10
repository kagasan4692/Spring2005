import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class point02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру месяца от 1 до 12");
        int enteredMonth = scanner.nextInt();

        System.out.println("Введите год в формате YYYY");
        int enteredYear = scanner.nextInt();

        int i = 0;
        Double min = 0.0, max = 0.0, compareMin = 0.0, compareMax = 0.0, doubleUsdValue;
        while (i < 31) {
            i++;
            try {
                String date = getDate(i, enteredMonth, enteredYear);
                System.out.println(getDate(i, enteredMonth, enteredYear) + " : " + usdValue(date) + " руб/доллар");

                doubleUsdValue = Double.parseDouble(usdValue(date).replace(',', '.'));

                if (i == 1) {
                    compareMin = doubleUsdValue;
                    compareMax = doubleUsdValue;
                } else {
                    min = Math.min(compareMin, doubleUsdValue);
                    compareMin = min;

                    max = Math.max(compareMax, doubleUsdValue);
                    compareMax = max;
                }

            } catch (Throwable t) {
                i = 31;
            }
        }
        String minValue = Double.toString(min).replace(".", ",");
        String maxValue = Double.toString(max).replace(".", ",");

        System.out.println("Минимальное значение за месяц : " + minValue);
        System.out.println("Максимальное значение за месяц : " + maxValue);
    }

    private static String getDate(int day, int month, int year) {
        String strDay = day < 10 ? "0" + day : Integer.toString(day);
        String strMonth = month < 10 ? "0" + month : Integer.toString(month);
        return strDay + "." + strMonth + "." + year;
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