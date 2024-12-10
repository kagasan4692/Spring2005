import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class exercise04 {
    public static void main(String[] args) throws IOException{

        // Указанный в этом задании API не работает без VPN. Поэтому я использовал другой API. Это рандомные цитаты!

        String page = downloadWebPage("https://favqs.com/api/qotd");

        int quoteStart = page.lastIndexOf("body");
        int quoteEnd = page.indexOf('}');

        String string = page.substring(quoteStart + 7, quoteEnd - 1);

        System.out.println(string);
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null){
                result.append(line);
            }
        }
        return result.toString();
    }

}
