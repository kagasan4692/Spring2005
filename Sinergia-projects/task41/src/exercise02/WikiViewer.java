package exercise02;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiViewer {
    private static String htmlCodeWiki;

    public void run() throws IOException {
        String pathToFile = "article.html";

        htmlCodeWiki = getURLSource("https://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");

        writeToFile(htmlCodeWiki, pathToFile);
        showWikiPage(pathToFile);

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

    private static void writeToFile(String str, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(str);
        writer.close();
    }

    private static void showWikiPage(String pathToFile) {
        File htmlFile = new File(pathToFile);

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(htmlFile.toURI());
            } catch (IOException e) {
                System.err.println("Не удалось открыть HTML-файл: " + e.getMessage());
            }
        } else {
            System.err.println("Desktop API не поддерживается на этой системе.");
        }
    }

    private static String extractParagraph() {
        String regex = "<p>(.*?)</p>";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(htmlCodeWiki);
        String str = "";
        while (matcher.find()) {
            str = str + matcher.group(1) + "\n";
        }

        return str;
    }

    @Override
    public String toString(){
        return extractParagraph();
    }
}
