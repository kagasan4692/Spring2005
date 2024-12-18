package point01;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EnterTheData {
    public static final String expenditure = "Расход";
    public static final String Income = "Доход";
    public static String[] enteredData() {
        Scanner scanner = new Scanner(System.in);

        String description = getTransactionDescription(scanner);

        String typeTransaction = getTypeTransaction(scanner);

        String sumTransaction = getSumTransaction(scanner);
        sumTransaction = typeTransaction.equals(expenditure) ? "-" + sumTransaction : sumTransaction;

        String dateTimeNow = getDAteTimeNow();

        String[] dataTransaction = {dateTimeNow, description, sumTransaction};

        return dataTransaction;
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
            System.out.print("Введите число " + "(1 - " + expenditure + ", 2 - " + Income + "): ");
            int debitOrCredit;

            try {
                debitOrCredit = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                debitOrCredit = 0;
            }

            switch (debitOrCredit) {
                case 1:
                    result = expenditure;

                    return result;
                case 2:
                    result = Income;

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
        return String.format("%.2f", value).replace(',', '.');
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
