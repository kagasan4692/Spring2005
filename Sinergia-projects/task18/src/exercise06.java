import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class exercise06 {
    public static void main(String[] args) throws IOException{
        QuotesBreakingBad quotes = new QuotesBreakingBad();
        int declaredFields = 2;

        String[][] dataQuotes = new String[10][declaredFields];

        for (int i = 0; i < dataQuotes.length; i++) {
            dataQuotes[i] = quotesBreakingBadRequest(quotes, declaredFields);
        }

        printingTwoDimensionalArray(dataQuotes);

    }

    private static String[] quotesBreakingBadRequest(QuotesBreakingBad quotes, int declaredFields) throws IOException {
        String json = downloadWebPage("https://api.breakingbadquotes.xyz/v1/quotes");

        int quoteStart = json.lastIndexOf("quote") + 8;
        int quoteEnd = json.lastIndexOf("author") - 3;
        quotes.quote = json.substring(quoteStart, quoteEnd);

        int authorStart = json.lastIndexOf("author") + 9;
        int authorEnd = json.lastIndexOf('}') - 1;
        quotes.author = json.substring(authorStart, authorEnd);

        String[] newArray = new String[declaredFields];
        newArray[0] = quotes.quote;
        newArray[1] = quotes.author;

        return newArray;
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

    private static void printingTwoDimensionalArray(String[][] filesArray) {
        for (int i = 0; i < filesArray.length; i++) {
            System.out.println("Цитата № " + (i + 1) + " :");
            for (int j = 0; j < filesArray[i].length; j++) {
                System.out.println(filesArray[i][j]);
            }
            System.out.println("---------------------");
        }
    }
}
