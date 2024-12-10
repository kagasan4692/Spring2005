package point01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EnterTheData {

    public static String getData() {
        String[] dataTransaction = enteredData();
        String input = "";
        input = addDataInString(input, "Текущая дата и время", dataTransaction[0]);
        input = addDataInString(input, "Описание сделки", dataTransaction[1]);
        input = addDataInString(input, "Сумма сделки", dataTransaction[2]);

        return '{' + input.trim() + '}';
    }

    private static String[] enteredData() {
        Scanner scanner = new Scanner(System.in);

        String description = getTransactionDescription(scanner);

        String typeTransaction = getTypeTransaction(scanner);

        String sumTransaction = getSumTransaction(scanner);
        sumTransaction = typeTransaction.equals("Расход") ? "-" + sumTransaction : sumTransaction;

        String dateTimeNow = getDAteTimeNow();

        String[] dataTransaction = {dateTimeNow, description, sumTransaction};

        return dataTransaction;
    }

    private static String addDataInString(String data, String title, String item){
        return data + "\n" + title + ": " + item + ";";
    }

    private static String getDAteTimeNow() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return now.format(formatter);
    }

    private static String getTransactionDescription(Scanner scanner) {

        System.out.print("Введите описание сделки: ");
        String result = scanner.nextLine().trim();

        return result;
    }

    private static String getTypeTransaction(Scanner scanner) {

        System.out.println("Выберите тип сделки: ");
        String result;

        while (true) {
            System.out.print("Введите число (1 - Расход, 2 - Доход): ");
            int debitOrCredit;

            try {
                debitOrCredit = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                debitOrCredit = 0;
            }

            switch (debitOrCredit) {
                case 1:
                    result = "Расход";

                    return result;
                case 2:
                    result = "Доход";

                    return result;
                default:
                    System.out.println("Неверный ввод!");
                    System.out.println("Выберите тип сделки заново: ");
            }
        }

    }

    private static String getSumTransaction(Scanner scanner) {

        System.out.print("Введите стоимость сделки: ");
        scanner.nextLine();
        String value;

        while (true) {
            value = scanner.nextLine().trim();

            if (value.contains(",")) {
                value = value.replace(',', '.');
            }

            if (isNumeric(value)) {
                return roundValue(value);
            } else {
                System.out.println("Неверный ввод! ");
                System.out.print("Введите стоимость заново: ");
            }
        }

    }

    private static String roundValue(String strNumber) {
        double value = Double.parseDouble(strNumber);
        return String.format("%.2f", value);
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
