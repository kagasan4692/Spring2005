import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Exercise05 {
    public static void main(String[] args) throws IOException{
        String quote = getQuotesBreakingBad("https://api.breakingbadquotes.xyz/v1/quotes");
        System.out.println(quote);
    }

    private static String getQuotesBreakingBad(String url) throws IOException {
        String json = downloadWebPage(url);

        int quoteStart = json.lastIndexOf("quote") + 8;
        int quoteEnd = json.lastIndexOf("author") - 3;
        String quote = json.substring(quoteStart, quoteEnd);

        return quote;
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
