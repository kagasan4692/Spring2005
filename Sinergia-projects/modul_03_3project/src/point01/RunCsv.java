package point01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RunCsv {

    public static final String notDataInfo = "Файл не содержит инфрмации, или отсутсвует!";
    public static final String yesNoInfo = "Добавить новую транзакцию - 1, Выйти из программы - 2.";
    public static final String yesNoListInfo = "Работаем со списком транзакций - 1, Работаем с отчетом по месяцам 2.";
    public static final String yesNoReadListInfo = "Получить список транзакций - 1, Добавить новую транзакцию 2.";
    public static final String yesNoAddNewTransactionInfo = "Добавить новую транзакцию - 1, Выйти из программы 2.";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePathCsv = "transactions.csv";
        CsvFileHandler csvHandler = new CsvFileHandler(filePathCsv);

        if (fileChecker(filePathCsv)) {
            System.out.println(yesNoListInfo);
            if (checkEnteredInt(scanner, yesNoListInfo)) {
                System.out.println(yesNoReadListInfo);
                if (checkEnteredInt(scanner, yesNoReadListInfo)) {
                    System.out.println("Список транзакций:");
                    System.out.println(csvHandler.readListTransactions());
                    System.out.println(yesNoAddNewTransactionInfo);
                    if (checkEnteredInt(scanner, yesNoAddNewTransactionInfo)) {
                        csvHandler.runTxt();
                    } else {
                        System.out.println("выходим из программы!");
                    }
                } else {
                    csvHandler.runTxt();
                }

            } else {
                System.out.println("Работаем по месяцам!");
                System.out.println(csvHandler.readMonthlyReport());
            }
        } else {
            System.out.println(notDataInfo);
            System.out.println(yesNoInfo);

            if (checkEnteredInt(scanner, yesNoInfo)) {
                csvHandler.runTxt();
            } else {
                System.out.println("выходим из программы!");
            }
        }
    }

    private static boolean fileChecker(String filePath) {
        File file = new File(filePath);

        return (file.exists() && file.length() > 0);
    }

    private static boolean checkEnteredInt(Scanner scanner, String condition) {
        while (true) {

            int value;
            try {
                value = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                value = 0;
            }

            switch (value) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Неверный ввод!");
                    System.out.println("Введите информацию заново: ");
                    System.out.println(condition);
            }
        }

    }

}
