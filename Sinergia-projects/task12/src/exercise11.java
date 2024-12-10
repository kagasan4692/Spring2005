import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class exercise11 {
    public static void main(String[] args) throws IOException {
        String day = "01", month = "02";

        for (int i = 1994; i <= 2024; i++) {
            String date = formatDate(day, month, i);
            String value = usdValue(date);
            System.out.println(date + " : " + value);
        }
    }

    private static String formatDate(String day, String monthDate, int year) {

        return day + "." + monthDate + "." + year;
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
        int search = page.lastIndexOf("R01235");

        int quoteStart = search + 40;
        int quoteEnd = quoteStart + 109;

        return search == -1 ? "нет данных по доллару" : page.substring(quoteStart, quoteEnd);
    }

    private static String usdValue(String date) throws IOException {
        String StringUsdValue = usdQuoteSbrRequest(date);

        if (!StringUsdValue.equals("нет данных по доллару")) {
            int substringStart = StringUsdValue.lastIndexOf("<Value>") + 7;
            int substringEnd = StringUsdValue.lastIndexOf("</Value>");
            StringUsdValue = StringUsdValue.substring(substringStart, substringEnd);
        }

        return StringUsdValue;
    }

}
