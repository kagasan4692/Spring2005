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
        } catch (IOException e){
            System.out.println();
            System.out.println("Создаю файл " + filePath + " ...");
            System.out.println();
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
        TransactionsDataArray dataByMonth = new TransactionsDataArray();
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

    public void writeDataToFile(String data){
        try {
            this.write(this.read() + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] createDataArray(String input) {
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

    public static int countClosingBraces(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*') {
                count++;
            }
        }

        return count;
    }

}
