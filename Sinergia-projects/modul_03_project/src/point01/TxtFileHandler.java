package point01;

import java.io.*;

public class TxtFileHandler extends FileHandler {
    public TxtFileHandler(String filePath) {
        super(filePath);
    }

    @Override
    public void write(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    @Override
    public String read() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(separator)) {
                    content.append(line).append("\n");
                } else {
                    break;
                }
            }
        }
        return content.toString();
    }

    @Override
    public String writeSumByMont(String[][][] data) {
        String result = "";
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {

                String year = data[i][0][1].substring(0, 4);
                int monthIndex = Integer.parseInt(data[i][0][1].substring(5, 7));
                String monthName = monthNames[monthIndex - 1];

                double sum = 0;
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j] != null) {
                        sum = sum + parseNumberFormat(data[i][j][2]);
                    }
                }
                result = result + separator + "\n" + monthName + " " + year + "\n" + "Итог: " + String.format("%.2f", sum) + "\n";
            }
        }


        return result;
    }

    private static Double parseNumberFormat(String strNumber) {
        strNumber = strNumber.replace(',', '.');
        return Double.parseDouble(strNumber);
    }

    public void processTransactionFile(EnterTheData enteredData) throws IOException {
        TransactionArrayProvider dataTransactions = new TransactionArrayProvider();
        TransactionsDataArray dataByMonth = new TransactionsDataArray();
        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();

        this.writeDataToFile(enteredData.getData());

        String[] data = dataTransactions.createDataArray(this.read());

        String[][] allTransaction = dataByMonth.getTransactionsArray(data);

        String[][][] transactionByMonth = monthlyTransaction.splitByMonthAndYear(allTransaction);

        String sumByMonth = this.writeSumByMont(transactionByMonth);

        this.writeDataToFile(sumByMonth);

        System.out.println("Данные сохранены в файле: " + this.filePath);
    }

    public void writeDataToFile(String data) throws IOException {
        try {
            this.write(this.read() + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
