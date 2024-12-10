package exercise06;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercise06 {
    final static String dateStart = "01.02.2024";
    final static String dateEnd = "30.11.2024";

    public static void main(String[] args) throws IOException {
        DatePeriod datePeriod = new DatePeriod();
        double[] dollarRates = datePeriod.getDollarRatesForPeriod(convertToLocalDate(dateStart), convertToLocalDate(dateEnd));
        printArray(dollarRates);
    }

    public static LocalDate convertToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return LocalDate.parse(date, formatter);
    }

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
