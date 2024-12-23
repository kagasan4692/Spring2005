package point01;

import java.io.*;

public class TxtFileHandler extends FileHandler {
    public static final String separator = "----------------";

    public void runTxt() throws IOException{
        processTransactionFile();
    }

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
        } catch (IOException e) {
            System.out.println();
            System.out.println("Создаю файл " + filePath + " ...");
            System.out.println();
        }
        return content.toString();
    }
    @Override
    public String readListTransactions() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(separator)) {
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

        String[][] transactionData = getTransactionData(content.toString());

        return dataListTransactionsToString(transactionData);
    }
    @Override
    public String readMonthlyReport() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 3;
            while ((line = reader.readLine()) != null) {
                i++;
                if (line.equals(separator)){
                    i = 0;
                }
                if (i == 1 || i== 2){
                    content.append(line).append("\n");
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[][] reportData = getReportData(content.toString());

        return dataReportToString(reportData);
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
                result = result + separator + "\n" + monthName + " " + year + "\n" + "Итог: " + String.format("%.2f", sum).replace(',', '.') + "\n";
            }
        }


        return result;
    }

    public static String[][] getTransactionData(String input) {

        String[] blocks = input.split("Текущая дата и время: ");
        String[][] data = new String[blocks.length - 1][3]; // Двумерный массив для хранения данных

        for (int i = 1; i < blocks.length; i++) {

            String block = blocks[i].trim();
            String[] lines = block.split(";\n");

            String dateTime = lines[0].trim(); // Дата и время
            String description = lines[1].replace("Описание сделки: ", "").trim(); // Описание
            String amount = lines[2].replace("Сумма сделки: ", "").replace(";", "").trim(); // Сумма

            data[i - 1][0] = dateTime;
            data[i - 1][1] = description;
            data[i - 1][2] = amount;
        }

        return data;
    }

    public static String[][] getReportData(String input) {
        String[] lines = input.split("\n");
        String[][] data = new String[lines.length / 2][2]; // Двумерный массив: каждая запись состоит из двух элементов

        int index = 0;
        for (int i = 0; i < lines.length; i += 2) {
            String month = lines[i].trim(); // Извлекаем месяц
            String total = lines[i + 1].replace("Итог: ", "").trim(); // Извлекаем итог

            data[index][0] = month;
            data[index][1] = total;
            index++;
        }

        return data;
    }

    private static Double parseNumberFormat(String strNumber) {
        strNumber = strNumber.replace(',', '.');
        return Double.parseDouble(strNumber);
    }

    private void processTransactionFile() throws IOException {
        EnterTheData enteredData = new EnterTheData();
        TransactionsDataTxtArray dataByMonth = new TransactionsDataTxtArray();
        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();

        writeNewData(enteredData);

        String[] dataRead = createDataArray(this.read());

        String[][] allTransaction = dataByMonth.getTransactionsArray(dataRead);

        String[][][] transactionByMonth = monthlyTransaction.splitByMonthAndYear(allTransaction);

        String sumByMonth = this.writeSumByMont(transactionByMonth);

        this.writeDataToFile(sumByMonth);

        System.out.println();
        System.out.println("Новые данные добавлены в файле: " + this.filePath);
    }

    private void writeNewData(EnterTheData enteredData) {
        String[] dataTransaction = enteredData.enteredData();

        String input = "";
        input = addDataInString(input, "Текущая дата и время", dataTransaction[0]);
        input = addDataInString(input, "Описание сделки", dataTransaction[1]);
        input = addDataInString(input, "Сумма сделки", dataTransaction[2]);

        String inputLine = input.trim() + "*";

        this.writeDataToFile(inputLine);
    }

    private static String addDataInString(String data, String title, String item) {
        return data + "\n" + title + ": " + item + ";";
    }

    private void writeDataToFile(String data) {
        try {
            this.write(this.read() + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] createDataArray(String input) {
        String[] substrings = new String[countClosingBraces(input)];

        int startIndex = 0;
        int count = 0;
        int middleIndex;
        int endIndex;

        while (count < countClosingBraces(input)) {
            startIndex = input.indexOf("Текущая дата и время:", startIndex);
            middleIndex = input.indexOf("Сумма сделки:", startIndex);
            endIndex = input.indexOf(';', middleIndex) + 1;
            String substring = input.substring(startIndex, endIndex);

            substrings[count] = substring;

            startIndex++;
            count++;
        }

        return substrings;
    }

    private static int countClosingBraces(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*') {
                count++;
            }
        }

        return count;
    }

}

class TransactionsDataTxtArray {
    private static String[][] getDataArray(String[] data) {
        String[][] result = new String[data.length][3];
        for (int i = 0; i < data.length; i++) {
            String[] transaction = new String[3];
            transaction[0] = getDescription(data[i]);
            transaction[1] = getDate(data[i]);
            transaction[2] = getSum(data[i]);

            result[i] = transaction;
        }

        return result;
    }

    private static String getDescription(String inputValue) {
        int startIndex = inputValue.indexOf("Описание сделки") + 17;
        int endIndex = inputValue.indexOf(';', startIndex);

        return inputValue.substring(startIndex, endIndex).trim();
    }


    private static String getDate(String inputValue) {
        int startIndex = inputValue.indexOf("Текущая дата и время") + 21;
        int endIndex = inputValue.indexOf(';', startIndex) - 9;

        return inputValue.substring(startIndex, endIndex).trim();
    }

    private static String getSum(String inputValue) {
        int startIndex = inputValue.indexOf("Сумма сделки") + 14;
        int endIndex = inputValue.indexOf(';', startIndex);

        return inputValue.substring(startIndex, endIndex).trim();
    }

    public static String[][] getTransactionsArray(String[] data) {
        return getDataArray(data);
    }

}
