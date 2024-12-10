import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите букву русской раскладки! Не используйте Й, Ы, Ъ, ь, Щ и т.д.");

        String letter = scanner.nextLine();

        boolean isFind = false;
        int j = 0;
        do {
            String randomString = getRandomString();
            j++;
            if (j < 20) {
                int quoteStart = randomString.lastIndexOf(" " + letter) + 1;
                int quoteEnd = randomString.lastIndexOf(".");

                if (quoteStart > 0) {
                    String quoteString = randomString.substring(quoteStart, quoteEnd);

                    int i = 0;
                    boolean isWord = false;

                    do {
                        if (quoteString.charAt(i) == ' ') {
                            isWord = true;
                        }

                        System.out.print(quoteString.charAt(i));
                        i++;


                    } while (!isWord && i < quoteString.length());

                    isFind = true;

                }
            } else {
                System.out.println("Доступ к API заблокирован! Превышен лимит запросов!");
                isFind = true;
            }


        } while (!isFind);

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

    private static String getRandomString() throws IOException {
        System.out.println("Ищем слово! Пожалуйста подождите!");
        System.out.println();
        String page = downloadWebPage("https://fish-text.ru/get?format=html&number=1");


        int quoteStart = page.lastIndexOf("<p>") + 3;
        int quoteEnd = page.lastIndexOf("</p>");

        return page.substring(quoteStart, quoteEnd);
    }
}
