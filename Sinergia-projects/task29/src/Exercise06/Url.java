package Exercise06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Url {
    public String url;

    public Url() {
        this.url = getUrl(LocalDate.now().toString());
        System.out.println("Инициализирована ссылка: " + this.url);
        System.out.println("Дата: " + LocalDate.now());
    }

    public Url(String date) {
            this.url = getUrl(date);
        System.out.println("Инициализирована ссылка: " + this.url);
        System.out.println("Дата: " + date);
    }

    private static String getUrl(String dateString) {
        String date = formatDate(dateString);

        return "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date;
    }

    private static String formatDate(String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
    }
}
