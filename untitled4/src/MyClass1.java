import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class MyClass1 {
    public static void main(String[] args) throws IOException {
        String sourceCode = getURLSource("https://ya.ru");
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/index.html"));
        writer.write(str);
        writer.close();
    }
}
