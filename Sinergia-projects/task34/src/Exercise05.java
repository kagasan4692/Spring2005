import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        System.out.println("Введите ссылку на API! например https://www.yandex.ru : ");
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();

        try {
            String page = downloadWebPage(url);
            if (page.equals(" ")){
                throw new RuntimeException("Ссылка "  + url + " не возвращает никакой информации");
            } else {
                System.out.println("Получена информация по ссылке: " + url);
                System.out.println(page);
                System.out.println("Длина полученной строки: " + page.length());
                saveToFile("downloaded_page.html", page);
                System.out.println("Страница успешно загружена и сохранена в файл downloaded_page.html.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка: страница не найдена или недоступна.");
        }
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

    private static void saveToFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
}
