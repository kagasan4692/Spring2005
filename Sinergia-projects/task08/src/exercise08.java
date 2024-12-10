import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class exercise08 {
    public static void main(String[] args) throws IOException {

        // Так как я использую другой API, то вместо Волтера Уайта буду использовать Конфуция!

        String page = downloadWebPage("https://favqs.com/api/qotd");

        int quoteStart = page.lastIndexOf("body");
        int quoteEnd = page.indexOf('}');
        String quote = page.substring(quoteStart + 7, quoteEnd - 1);

        int authorStart = page.lastIndexOf("downvotes_count");
        int authorEnd = page.indexOf("author_permalink");
        String author = page.substring(authorStart + 29, authorEnd - 3);

        String text;
//        if (!author.equals("Confucius")){
//            text = "Restart and try again";
//        } else {
//            text = quote + "/n" + author;
//        }
        
        text = !author.equals("Confucius") ? "Restart and try again" : quote + "/n" + author;

        System.out.println(text);

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
