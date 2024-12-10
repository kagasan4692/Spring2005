import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Exercise09 {
    public static void main(String[] args) throws IOException {
        String quote = quotesBreakingBadRequest();
//        quote ="You goddamn right.";
//        quote ="Nice try, asshole!";
        String censoredString = censoredString(quote);

        System.out.println(censoredString);
    }

    private static String censoredString(String quote){
        String[] badWords = {
                "damn", "hell", "bastard", "asshole", "crap",
                "shit", "bullshit", "bitch", "freak", "screw",
                "piss", "dick", "prick", "dumbass", "motherfucker",
                "fuck", "fucking", "jackass",
        };

        StringBuilder censoredQuote = new StringBuilder(quote);

        for (int i = 0; i < badWords.length; i++) {
            int index = censoredQuote.indexOf(badWords[i]);

            while (index != -1) {
                censoredQuote.replace(index, index + badWords[i].length(), "*".repeat(badWords[i].length()));

                index = censoredQuote.indexOf(badWords[i], index + 1);
            }
        }

        String censoredString = censoredQuote.toString();

        return censoredString;
    }

    private static String quotesBreakingBadRequest() throws IOException {
        String json = downloadWebPage("https://api.breakingbadquotes.xyz/v1/quotes");

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
