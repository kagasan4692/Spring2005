package exercise06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePeriod {

    public static double[] getDollarRatesForPeriod(LocalDate startDate, LocalDate endDate) throws IOException {
        System.out.println("Получаем курс доллара за указанный период. Пожалуста подождите!");
        int daysBetween = (int) (endDate.toEpochDay() - startDate.toEpochDay() + 1);

        double[] array = new double[daysBetween];
        int i = 0;
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            String data = formatLocalDate(currentDate);

            array[i] = usdValue(data);
            currentDate = currentDate.plusDays(1);
            i++;
        }
        return array;
    }

    public static String formatLocalDate(LocalDate date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }


    public static String downloadWebPage(String url) throws IOException {
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

    public static String usdQuoteSbrRequest(String date) throws IOException {
        String page = downloadWebPage("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);

        int quoteStart = page.lastIndexOf("R01235") + 40;
        int quoteEnd = quoteStart + 109;

        return page.substring(quoteStart, quoteEnd);
    }

    public static double usdValue(String date) throws IOException {
        String StringUsdValue = usdQuoteSbrRequest(date);

        int substringStart = StringUsdValue.lastIndexOf("<Value>") + 7;
        int substringEnd = StringUsdValue.lastIndexOf("</Value>");

        String value = StringUsdValue.substring(substringStart, substringEnd).replace(",", ".");
        double valueDouble = Double.parseDouble(value);
        return Math.round(valueDouble * 100.0) / 100.0;
    }
}
