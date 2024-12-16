package point01;

import java.io.IOException;

public class RunCsv {
    public static void main(String[] args) throws IOException {
        CsvFileHandler csvHandler = new CsvFileHandler("transactions.csv");
        EnterTheData enteredData = new EnterTheData();

        try {
            String input = csvHandler.read();

            if (input.equals("")) {
                System.out.println("Данных в файле нет!");
                System.out.println("Введите новые данные!");

                processTransactionFile(csvHandler, enteredData);
            } else {
                processTransactionFile(csvHandler, enteredData);
            }

        } catch (IOException e) {
            System.out.println("Нет файла!");
            System.out.println("Введите новые данные!");

            csvHandler.write(enteredData.getData());
        }
    }

    public static void processTransactionFile(CsvFileHandler csvHandler, EnterTheData enteredData) throws IOException {
        TransactionArrayProvider dataTransactions = new TransactionArrayProvider();
        TransactionsDataArray dataByMonth = new TransactionsDataArray();
        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();

        csvHandler.write(csvHandler.read() + enteredData.getData());

        String[] data = dataTransactions.createDataArray(csvHandler.read());

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }


        String[][] allTransaction = dataByMonth.getTransactionsArray(data);

        String[][][] transactionByMonth = monthlyTransaction.splitByMonthAndYear(allTransaction);

        String sumByMonth = csvHandler.writeSumByMont(transactionByMonth);

        csvHandler.write(csvHandler.read() + sumByMonth);

        System.out.println("Данные сохранены в файле: " + csvHandler.filePath);
    }
}
