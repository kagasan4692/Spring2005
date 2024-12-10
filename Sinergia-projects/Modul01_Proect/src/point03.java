import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class point03 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру месяца от 1 до 12");
        int enteredMonth = scanner.nextInt();

        String monthString = getMonthWord(enteredMonth);

        if (monthString.equals("Вы неверно ввели номер месяца")) {
            System.out.println(monthString);
        } else {
            System.out.println("Введите год в формате YYYY");
            int enteredYear = scanner.nextInt();

            String monthYear = monthString + "_" + enteredYear + "_года";

            int i = 0;

            Double delta, maxDown = 0.0, maxUp = 0.0, compare = 0.0, doubleUsdValue;
            String dataUp = "";
            String dataDown = "";

            while (i < 31) {
                i++;
                try {
                    String date = getDate(i, enteredMonth, enteredYear);
                    System.out.println(getDate(i, enteredMonth, enteredYear) + " : " + usdValue(date) + " руб/доллар");

                    doubleUsdValue = Double.parseDouble(usdValue(date).replace(',', '.'));

                    if (i == 1) {
                        compare = doubleUsdValue;

                    } else if (i == 2) {
                        delta = doubleUsdValue - compare;
                        maxUp = delta;
                        maxDown = delta;
                        dataUp = date;
                        dataDown = date;

                    } else {
                        delta = doubleUsdValue - compare;

                        if (maxUp < delta) {
                            dataUp = date;
                            maxUp = Math.max(maxUp, delta);
                        }

                        if (maxDown > delta) {
                            dataDown = date;
                            maxDown = Math.min(maxDown, delta);
                        }

                        compare = doubleUsdValue;


                    }

                } catch (Throwable t) {
                    i = 31;
                }
            }
            System.out.println(" ");

            if (maxUp != 0) {
                System.out.println("Самый большой скачек доллара в вверх : " + dataUp
                        + " = " + getDateStringFormat(maxUp) + " руб.");
            } else {
                System.out.println("Повышения стоимости доллара за период небыло");
            }

            if (maxDown != 0) {
                System.out.println("Самый большой скачек доллара в вниз : " + dataDown
                        + " = " + getDateStringFormat(maxDown) + " руб.");
            } else {
                System.out.println("Понижения стоимости доллара за период небыло");
            }

            System.out.println(" ");

            String dateX;
            if (maxUp > Math.abs(maxDown)) {
                System.out.println("Самый большой скачек доллара  : " + dataUp
                        + " = " + getDateStringFormat(maxUp) + " руб.");
                dateX = dataUp;
            } else if (maxUp < Math.abs(maxDown)) {
                System.out.println("Самый большой скачек доллара : " + dataDown
                        + " = " + getDateStringFormat(maxDown) + " руб.");
                dateX = dataDown;
            } else {
                System.out.println("Изменений за период не было");
                dateX = "Нет даты";
            }

            System.out.println(" ");

            if (dateX.equals("Нет даты")) {
                System.out.println("Мы не можем запросить статью из Википедии");
            } else {
                System.out.println("Запрашиваем ссылку на Википедии ...");
                String monthYearLink = quoteWikiMontYarRequest(monthYear);

                System.out.println(monthYearLink);
                System.out.println("Ссылка на " + monthYear + " получена...");
                System.out.println(" ");
                System.out.println("Запрашиваем по ссылке текст, отвечающий за факты на дату  : " + dateX);
                System.out.println(" ");
                String quoteThisDay = quoteWikiDateRequest(monthYearLink, Integer.parseInt(dateX.substring(0, 2)));

                if (quoteThisDay.equals("Не удалось получить текст...")) {
                    System.out.println(quoteThisDay);
                } else {
                    System.out.println(quoteThisDay);
                    System.out.println("Текст получен!");
                }


            }
        }


    }

    private static String getMonthWord(int enteredMonth) {
        String monthString;
        if (enteredMonth == 1) {
            monthString = "Январь";
        } else if (enteredMonth == 2) {
            monthString = "Февраль";
        } else if (enteredMonth == 3) {
            monthString = "Март";
        } else if (enteredMonth == 4) {
            monthString = "Апрель";
        } else if (enteredMonth == 5) {
            monthString = "Май";
        } else if (enteredMonth == 6) {
            monthString = "Июнь";
        } else if (enteredMonth == 7) {
            monthString = "Июль";
        } else if (enteredMonth == 8) {
            monthString = "Август";
        } else if (enteredMonth == 9) {
            monthString = "Сентябрь";
        } else if (enteredMonth == 10) {
            monthString = "Октябрь";
        } else if (enteredMonth == 11) {
            monthString = "Ноябрь";
        } else if (enteredMonth == 12) {
            monthString = "Декабрь";
        } else {
            monthString = "Вы неверно ввели номер месяца";
        }

        return monthString;
    }

    private static String getDateStringFormat(Double date) {

        return Double.toString(date).replace(".", ",");
    }

    private static String getDate(int day, int month, int year) {
        String strDay = day < 10 ? "0" + day : Integer.toString(day);
        String strMonth = month < 10 ? "0" + month : Integer.toString(month);
        return strDay + "." + strMonth + "." + year;
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

    private static String quoteWikiMontYarRequest(String monthYear) throws IOException {

        String page = downloadWebPage("https://ru.wikipedia.org/wiki/" + monthYear);

        int quoteStart = page.lastIndexOf("https://ru.wikipedia.org/wiki/");
        int quoteEnd = page.lastIndexOf("https://creativecommons.org/") - 28;
        return page.substring(quoteStart, quoteEnd);
    }

    private static String quoteWikiDateRequest(String url, int day) throws IOException {
        String page = downloadWebPage(url);
        String quoteThisDay;
        try {
            int quoteStart = page.lastIndexOf("/wiki/" + day + "_");
            int nextDay = day + 1;
            int quoteEnd = page.lastIndexOf("/wiki/" + nextDay + "_") - 16;
            quoteThisDay = page.substring(quoteStart, quoteEnd);

        } catch (Throwable t) {
            quoteThisDay = "Не удалось получить текст...";
        }

        return quoteThisDay;

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