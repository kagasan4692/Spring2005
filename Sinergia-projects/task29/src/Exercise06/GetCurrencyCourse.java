package Exercise06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetCurrencyCourse {
    public double usdValue;
    public double eurValue;

    public GetCurrencyCourse(String url) throws IOException {
        this.usdValue = Double.parseDouble(courseValue(url)[0]);
        this.eurValue = Double.parseDouble(courseValue(url)[1]);
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

    private static String[] quoteSbrRequest(String url) throws IOException {
        String page = downloadWebPage(url);

        int quoteUsdStart = page.lastIndexOf("R01235") + 40;
        int quoteUsdEnd = quoteUsdStart + 109;
        String usd = page.substring(quoteUsdStart, quoteUsdEnd);

        int quoteEurStart = page.lastIndexOf("R01239") + 40;
        int quoteEurEnd = quoteEurStart + 109;
        String eur = page.substring(quoteEurStart, quoteEurEnd);

        String[] newArray = {usd, eur};

        return newArray;
    }

    private static String[] courseValue(String url) throws IOException {
        String[] StringUsdValue = quoteSbrRequest(url);

        int quoteUsdStart = StringUsdValue[0].lastIndexOf("<Value>") + 7;
        int quoteUsdEnd = StringUsdValue[0].lastIndexOf("</Value>");
        String usd = StringUsdValue[0].substring(quoteUsdStart, quoteUsdEnd).replaceAll(",", ".");
        ;

        int quoteEurStart = StringUsdValue[1].lastIndexOf("<Value>") + 7;
        int quoteEurEnd = StringUsdValue[1].lastIndexOf("</Value>");
        String eur = StringUsdValue[1].substring(quoteEurStart, quoteEurEnd).replaceAll(",", ".");

        String[] newArray = {usd, eur};

        return newArray;
    }

}
