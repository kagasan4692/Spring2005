import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class Exercise07 {
    private static final String apiKey = "D6q5GOfTwbkkYfdnHZXgmRoIlNstZxbyxqUkHDBh";

    public static void main(String[] args) throws IOException {
        String date = LocalDate.of(2021, 3, 2).toString();

        String explanation = getNasaExplanation(date);
        System.out.println("Описание для снимка на дату: " + date);
        System.out.println(explanation);
    }

    public static String getNasaExplanation(String date) throws IOException {
        String dateForLink = "&date=" + date + "&";
        String page = downloadWebPage("https://api.nasa.gov/planetary/apod?" + dateForLink + "api_key=" + apiKey);

        int quoteExplanationStart = page.lastIndexOf("explanation") + 14;
        int quoteExplanationEnd = page.lastIndexOf("hdurl") - 3;
        String explanation = page.substring(quoteExplanationStart, quoteExplanationEnd);

        return explanation;
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
