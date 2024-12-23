package point01;

import java.io.*;

public class CsvFileHandler extends FileHandler {
    public void runTxt() throws IOException{
        processTransactionFile();
    }

    public CsvFileHandler(String filePath) {
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
                if (!line.trim().equals("")) {
                    content.append(line).append("\n");
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println();
            System.out.println("Создаю файл " + filePath + " ...");
            System.out.println();
        }
        return content.toString();
    }

    public String readListTransactions() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals("")) {
                    content.append(line.replace("*", "")).append("\n");
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println();
            System.out.println("Создаю файл " + filePath + " ...");
            System.out.println();
        }
        return content.toString();
    }

    public String readMonthlyReport() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 3;
            while ((line = reader.readLine()) != null) {
                i++;
                if (line.trim().equals("")){
                    i = 0;
                }
                if (i == 1 || i== 2){
                    content.append(line).append("\n");
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content.toString();
    }

    @Override
    public String writeSumByMont(String[][][] data) {
        StringBuilder result = new StringBuilder();
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
                result.append("\n").append("Календарный период,").append("Итог").append("\n")
                        .append(monthName).append(" ").append(year).append(",")
                        .append(String.format("%.2f", sum).replace(',', '.')).append("\n");
            }
        }
        return result.toString();
    }

    private static Double parseNumberFormat(String strNumber) {
        strNumber = strNumber.replace(',', '.');
        return Double.parseDouble(strNumber);
    }

    public void processTransactionFile() throws IOException {
        EnterTheData enteredData = new EnterTheData();
        TransactionsDataCsvArray dataByMonth = new TransactionsDataCsvArray();
        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();

        writeNewData(enteredData);

        String[] dataRead = createDataArray(this.read());

        String[][] allTransaction = dataByMonth.getTransactionsArray(dataRead);

        String[][][] transactionByMonth = monthlyTransaction.splitByMonthAndYear(allTransaction);

        String sumByMonth = this.writeSumByMont(transactionByMonth);

        this.writeDataToFile(sumByMonth);

        System.out.println();
        System.out.println("Новые данные добавлены в файл: " + this.filePath);
    }

    public static String[] createDataArray(String input) {
        String[] substrings = new String[countClosingBraces(input)];

        int startIndex = 0;
        int j = 0;
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '\n') {
                if (startIndex != 0) {
                    substrings[j] = input.substring(startIndex, i);
                    j++;
                }
                startIndex = i + 1;
            }
        }

        return substrings;
    }

    public static int countClosingBraces(String input) {
        int count = 0;
        int startIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\n') {
                if (startIndex != 0) {
                    count++;
                }
                startIndex = i + 1;
            }
        }

        return count;
    }

    private void writeNewData(EnterTheData enteredData) {
        String[] dataTransaction = enteredData.enteredData();

        String input = dataTransaction[0] + "," + dataTransaction[1] + "," + dataTransaction[2];


        String inputLine = input.trim();

        this.writeDataToFile(inputLine);
    }

    public void writeDataToFile(String data) {
        String header = "Текущая дата и время" + "," + "Описание сделки" + "," + "Сумма сделки" + "\n";
        try {
            if (new File(filePath).length() == 0) {
                this.write(header + data);
            } else {
                this.write(this.read() + data);
            }
        } catch (IOException e) {

        }
    }
}

class TransactionsDataCsvArray {
    private static String[][] getDataArray(String[] data) {
        String[][] result = new String[data.length][3];
        for (int i = 0; i < data.length; i++) {
            String[] transaction = new String[3];

            int startIndex = 0;
            int endIndex = data[i].indexOf(',', startIndex);
            transaction[1] = data[i].substring(startIndex, endIndex - 9);

            startIndex = endIndex + 1;
            endIndex = data[i].indexOf(',', startIndex);
            transaction[0] = data[i].substring(startIndex, endIndex).trim();

            startIndex = endIndex + 1;
            endIndex = data[i].length();

            transaction[2] = data[i].substring(startIndex, endIndex).trim();

            result[i] = transaction;
        }

        return result;
    }

    public static String[][] getTransactionsArray(String[] data) {
        return getDataArray(data);
    }

}
