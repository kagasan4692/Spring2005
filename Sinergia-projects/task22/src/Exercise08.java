import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате дд месяц гггг (например: 20 января 2020).");

        String date = scanner.nextLine();
        date = formatDate(date);

        if (date.equals("Неизвестный месяц.")) {
            System.out.println("Ошибка! Неправильно указан месяц");
        } else {
            String value = usdValue(date);
            System.out.println(date + " : " + value);
        }

    }

    private static String formatDate(String date) {
        StringBuilder modifiedDate = new StringBuilder(date);
        StringBuilder dayBuilder = new StringBuilder();

        boolean isSpace = false;
        int j = 0;
        do {
            if (modifiedDate.charAt(j) == ' ') {
                isSpace = true;

            } else {
                dayBuilder.append(modifiedDate.charAt(j));
            }
            j++;

        } while (!isSpace);

        if (dayBuilder.length() == 1) {
            dayBuilder.insert(0, '0');
        }

        StringBuilder monthBuilder = new StringBuilder();
        StringBuilder yearBuilder = new StringBuilder();

        isSpace = false;
        for (int i = 0; i < modifiedDate.length(); i++) {

            if (modifiedDate.charAt(i) == ' ') {
                isSpace = !isSpace;
            }

            if (isSpace) {
                if (modifiedDate.charAt(i) != ' ') {
                    monthBuilder.append(modifiedDate.charAt(i));
                }
            }

            if (i == modifiedDate.length() - 4 || i == modifiedDate.length() - 3 || i == modifiedDate.length() - 2 || i == modifiedDate.length() - 1) {
                yearBuilder.append(modifiedDate.charAt(i));
            }


        }

        String day = dayBuilder.toString();

        String month = parseMonth(monthBuilder.toString());

        String year = yearBuilder.toString();

        String dateString;

        if (month.equals("Неизвестный месяц")) {
            dateString = "Неизвестный месяц";

        } else {
            dateString = day + "." + month + "." + year;
        }

        return dateString;
    }

    private static String parseMonth(String month) {
        String monthNumber;
        switch (month) {
            case "января":
                monthNumber = "01";
                break;
            case "февраля":
                monthNumber = "02";
                break;
            case "марта":
                monthNumber = "03";
                break;
            case "апреля":
                monthNumber = "04";
                break;
            case "мая":
                monthNumber = "05";
                break;
            case "июня":
                monthNumber = "06";
                break;
            case "июля":
                monthNumber = "07";
                break;
            case "августа":
                monthNumber = "08";
                break;
            case "сентября":
                monthNumber = "09";
                break;
            case "октября":
                monthNumber = "10";
                break;
            case "ноября":
                monthNumber = "11";
                break;
            case "декабря":
                monthNumber = "12";
                break;
            default:
                monthNumber = "Неизвестный месяц";

        }

        return monthNumber;
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
