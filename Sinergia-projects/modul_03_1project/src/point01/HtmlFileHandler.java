package point01;

import java.io.*;

public class HtmlFileHandler extends FileHandler {

    public HtmlFileHandler(String filePath) {
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
                if (!line.trim().contains("</body>")) {
                    content.append(line).append("\n");
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Создаю новый: " + filePath);
        }
        return content.toString();
    }

    @Override
    public String writeSumByMont(String[][][] data) {
        StringBuilder result = new StringBuilder();
        result.append("<html>\n<head>\n<title>Transaction Summary</title>\n</head>\n<body>\n");
        result.append("<h1>Итоги по месяцам</h1>\n<table border='1'>\n<tr><th>Месяц</th><th>Год</th><th>Сумма</th></tr>\n");

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                String year = data[i][0][1].substring(0, 4);
                int monthIndex = Integer.parseInt(data[i][0][1].substring(5, 7));
                String monthName = monthNames[monthIndex - 1];

                double sum = 0;
                for (String[] transaction : data[i]) {
                    if (transaction != null) {
                        sum += parseNumberFormat(transaction[2]);
                    }
                }
                result.append("<tr><td>").append(monthName).append("</td><td>")
                        .append(year).append("</td><td>")
                        .append(String.format("%.2f", sum)).append("</td></tr>\n");
            }
        }

        result.append("</table>\n</body>\n</html>");
        return result.toString();
    }

    private static double parseNumberFormat(String strNumber) {
        strNumber = strNumber.replace(',', '.');
        return Double.parseDouble(strNumber);
    }

    public void processTransactionFile(EnterTheData enteredData) throws IOException {
        TransactionsDataHtmlArray dataByMonth = new TransactionsDataHtmlArray();
        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();

        writeNewData(enteredData);
        String[] dataRead = createDataArray(this.read());

        String[][] allTransactions = dataByMonth.getTransactionsArray(dataRead);
        String[][][] transactionsByMonth = monthlyTransaction.splitByMonthAndYear(allTransactions);

        String sumByMonth = writeSumByMont(transactionsByMonth);
        System.out.println(sumByMonth);
//        write(sumByMonth);

//        System.out.println("Данные обновлены в файле: " + filePath);
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

    private void writeNewData(EnterTheData enteredData) throws IOException {
        String[] dataTransaction = enteredData.enteredData();
        String newRow = "<tr><td>" + dataTransaction[0] + "</td><td>" +
                dataTransaction[1] + "</td><td>" + dataTransaction[2] + "</td></tr>\n";

        writeDataGeneralParty(newRow);
    }

    public void writeDataGeneralParty(String data) throws IOException {
        String header = "<html lang=\"ru\">\n<head>\n<meta charset=\"utf-8\">\n<title>Transactions</title>\n</head>\n<body>\n<h3>Список транзакций</h3>\n<table border='1'>\n<tr><th>Дата</th><th>Описание</th><th>Сумма</th></tr>\n";
        if (new File(filePath).length() == 0) {
            write(header + data + "</table>\n</body>\n</html>");
        } else {
            String existingContent = read();
            int endIndex = existingContent.lastIndexOf("</table>");
            if (endIndex != -1) {
                String updatedContent = existingContent.substring(0, endIndex) + data + "</table>\n</body>\n</html>";
                write(updatedContent);
            } else {
                write(existingContent + data + "</table>\n</body>\n</html>");
            }
        }
    }

}

class TransactionsDataHtmlArray {
    private static String[][] getDataArray(String[] data) {

        String[][] result = new String[counterLines(data)][3];
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        int j = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i].contains("<td>")) {
                String[] cells = data[i].split("</td><td>");
                result[j][1] = cells[0].replace("<tr><td>", "").trim().substring(0, 10);
                result[j][0] = cells[1];
                result[j][2] = cells[2].replace("</td></tr>", "").trim();
                j++;
            }
        }

        return result;
    }

    public static int counterLines(String[] data) {
        int count = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i].contains("<td>")) {
                count++;
            }
        }
        return count;
    }

    public static String[][] getTransactionsArray(String[] data) {
        return getDataArray(data);
    }
}