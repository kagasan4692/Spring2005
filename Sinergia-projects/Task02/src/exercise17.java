import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class exercise17 {
    public static void main(String[] args) throws IOException {
        String sourceCode = getURLSource("https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D0%B0_2000_%D0%B3%D0%BE%D0%B4%D0%B0");
        System.out.println(sourceCode);
        writeToFile(sourceCode);
    }

    private static String getURLSource(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        }
    }
    public static void writeToFile(String str) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/kagasan-test/Documents/index.html"));
        writer.write(str);
        writer.close();
    }
}
