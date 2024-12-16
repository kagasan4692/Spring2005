package point01;

import java.io.IOException;

public class RunHtml {
    public static void main(String[] args) throws IOException {
        HtmlFileHandler htmlHandler = new HtmlFileHandler("transactions.html");
        EnterTheData enteredData = new EnterTheData();

        try {
            String input = htmlHandler.read();

            if (input.equals("")) {
                System.out.println("Данных в файле нет!");
                System.out.println("Введите новые данные!");

                processTransactionFile(htmlHandler, enteredData);
            } else {
                processTransactionFile(htmlHandler, enteredData);
            }

        } catch (IOException e) {
            System.out.println("Нет файла!");
            System.out.println("Введите новые данные!");

            htmlHandler.write(enteredData.getData());
        }
    }

    public static void processTransactionFile(HtmlFileHandler htmlHandler, EnterTheData enteredData) throws IOException {
        TransactionArrayProvider dataTransactions = new TransactionArrayProvider();
        TransactionsDataArray dataByMonth = new TransactionsDataArray();
        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();

        htmlHandler.write(htmlHandler.read() + enteredData.getData());

        String[] data = dataTransactions.createDataArray(htmlHandler.read());

        String[][] allTransaction = dataByMonth.getTransactionsArray(data);

        String[][][] transactionByMonth = monthlyTransaction.splitByMonthAndYear(allTransaction);

        String sumByMonth = htmlHandler.writeSumByMont(transactionByMonth);

        htmlHandler.write(htmlHandler.read() + sumByMonth);

        System.out.println("Данные сохранены в файле: " + htmlHandler.filePath);
    }
}
