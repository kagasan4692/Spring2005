package point01;

import java.io.IOException;

public class RunTxt {

    public static void main(String[] args) throws IOException{
        TxtFileHandler txtHandler = new TxtFileHandler("example.txt");
        EnterTheData enteredData = new EnterTheData();


        try {

            String input = txtHandler.read();

            if (input.equals("")) {
                System.out.println("Данных в файле нет!");
                System.out.println("Введите новые данные!");

                txtHandler.processTransactionFile(enteredData);
            } else {
                txtHandler.processTransactionFile(enteredData);
            }


        } catch (IOException e) {
            System.out.println("Нет файла!");
            System.out.println("Введите новые данные!");

            txtHandler.writeDataToFile(enteredData.getData());
        }

    }

//    public static void processTransactionFile(TxtFileHandler txtHandler, EnterTheData  enteredData) throws IOException {
//        TransactionArrayProvider dataTransactions = new TransactionArrayProvider();
//        TransactionsDataArray dataByMonth = new TransactionsDataArray();
//        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();
//
//        writeDataToFile(txtHandler, enteredData.getData());
//
//        String[] data = dataTransactions.createDataArray(txtHandler.read());
//
//        String[][] allTransaction = dataByMonth.getTransactionsArray(data);
//
//        String[][][] transactionByMonth = monthlyTransaction.splitByMonthAndYear(allTransaction);
//
//        String sumByMonth = txtHandler.writeSumByMont(transactionByMonth);
//
//        writeDataToFile(txtHandler, sumByMonth);
//
//        System.out.println("Данные сохранены в файле: example.txt");
//    }
//
//    public static void writeDataToFile(TxtFileHandler txtHandler, String data) throws IOException {
//        try {
//            txtHandler.write(txtHandler.read() + data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
