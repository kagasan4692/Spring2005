import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Exercise03 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd.MM.yyyy :");
        String date = scanner.nextLine();

        if (isValidDate(date)){
            String value = usdValue(date);
            System.out.println(date + " : " + value);
        } else {
            DateFormatNotCorrect exception = new DateFormatNotCorrect();
            throw exception;
        }



    }

    public static boolean isValidDate(String date) {
        if (date == null || date.isEmpty()) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
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

    private static String usdQuoteSbrRequest(String date) throws IOException {
        String page = downloadWebPage("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);

        int quoteStart = page.lastIndexOf("R01235") + 40;
        if (page.lastIndexOf("R01235") == -1){
            NoDataDollarExchangeRate exeption = new NoDataDollarExchangeRate();
            throw exeption;
        }
        int quoteEnd = quoteStart + 109;

        return page.substring(quoteStart, quoteEnd);
    }

    private static String usdValue(String date) throws IOException {
        String StringUsdValue = usdQuoteSbrRequest(date);

        int substringStart = StringUsdValue.lastIndexOf("<Value>") + 7;
        int substringEnd = StringUsdValue.lastIndexOf("</Value>");

        return StringUsdValue.substring(substringStart, substringEnd);
    }
}

class NoDataDollarExchangeRate extends RuntimeException {
    public NoDataDollarExchangeRate(){
        super("Нет данных по курсу доллара!");
    }
}

class DateFormatNotCorrect extends RuntimeException {
    public DateFormatNotCorrect(){
        super("Неверный ввод даты!");
    }
}