package point01;

import java.io.*;

public class HtmlFileHandler extends FileHandler {
    @Override
    public void run() throws IOException {
        processTransactionFile();
    }

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
    public String readListTransactions() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().contains("<h3>Итоги по месяцам</h3>")) {
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

        String[][] transactionData = getTransactionData(content.toString());

        return dataListTransactionsToString(transactionData);
    }

    @Override
    public String readMonthlyReport() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (line.trim().contains("<h3>Итоги по месяцам</h3>")) {
                    i = 1;
                }

                if (i > 0) {
                    i++;
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
        StringBuilder result = new StringBuilder();
        result.append("<h3>Итоги по месяцам</h3>\n<table border='1'>\n" +
                "<tr><th>Месяц</th><th>Год</th><th>Сумма</th></tr>\n");

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
                        .append(String.format("%.2f", sum).replace(",", ".")).append("</td></tr>\n");
            }
        }

        result.append("</table>\n");
        return result.toString();
    }

    private static String[][] getTransactionData(String html) {

        String tableContent = html.substring(html.indexOf("<table"), html.indexOf("</table>") + "</table>".length());

        String[] rows = tableContent.split("<tr>");

        String[][] data = new String[rows.length - 2][3]; // Минус заголовок (<th>) и пустая строка до <tr>

        int rowIndex = 0;
        for (int i = 1; i < rows.length; i++) {
            if (!rows[i].contains("<td>")) continue;

            String[] cells = rows[i].split("<td>|</td>");
            int colIndex = 0;

            for (String cell : cells) {
                if (!cell.trim().isEmpty() && !cell.contains("<")) {
                    data[rowIndex][colIndex++] = cell.trim();
                }
            }
            rowIndex++;
        }

        return data;
    }

    private static String[][] getReportData(String html) {

        String tableContent = html.substring(html.indexOf("<table"), html.indexOf("</table>") + "</table>".length());

        String[] rows = tableContent.split("<tr>");

        String[][] data = new String[rows.length - 2][2];

        int rowIndex = 0;
        for (int i = 1; i < rows.length; i++) {

            if (!rows[i].contains("<td>")) continue;

            String[] cells = parseRow(rows[i]);

            int colIndex = 0;

            for (int j = 0; j < cells.length; j++) {
                String cell = cells[j];
                if (!cell.trim().isEmpty() && !cell.contains("<")) {
                    data[rowIndex][colIndex++] = cell.trim();
                }
            }
            rowIndex++;
        }

        return data;
    }

    public static String[] parseRow(String input) {

        String[] cells = input.split("</td><td>|<td>|</td></tr>");

        String[] resultArray = new String[2];

        for (int i = 1; i < cells.length; i++) {
            if (i == 2) {
                resultArray[0] = cells[i - 1] + " " + cells[i];
            } else if (i == 3) {
                resultArray[1] = cells[i];
            }
        }

        return resultArray;
    }

    private static double parseNumberFormat(String strNumber) {
        strNumber = strNumber.replace(',', '.');
        return Double.parseDouble(strNumber);
    }

    private void processTransactionFile() throws IOException {
        EnterTheData enteredData = new EnterTheData();
        TransactionsDataHtmlArray dataByMonth = new TransactionsDataHtmlArray();
        MonthlyTransactionArrays monthlyTransaction = new MonthlyTransactionArrays();

        String header = "<html lang=\"ru\">\n<head>\n<meta charset=\"utf-8\">\n<title>Transactions</title>\n" +
                "</head>\n<body>\n<h3>Список транзакций</h3>\n<table border='1' class=\"general-table\">\n" +
                "<tr><th>Дата</th><th>Описание</th><th>Сумма</th></tr>\n";

        String closeTable = "</table>\n";

        String footer = "</body>\n</html>";

        if (this.read().equals("")) {
            String enteredRow = writeNewData(enteredData);
            write(header + enteredRow + closeTable);
        } else {
            String oldRows = getRows(this.read());
            String enteredRow = writeNewData(enteredData);
            write(header + oldRows + "\n" + enteredRow + closeTable);
        }
        String[] dataRead = createDataArray(this.read());
        String[][] allTransactions = dataByMonth.getTransactionsArray(dataRead);
        String[][][] transactionsByMonth = monthlyTransaction.splitByMonthAndYear(allTransactions);
        String sumByMonth = writeSumByMont(transactionsByMonth);
        writeToFile(sumByMonth + footer);
        System.out.println("Данные обновлены в файле: " + filePath);
    }

    private static String getRows(String string) {
        int startIndex = string.indexOf("general-table");
        int endIndex = string.indexOf("</table>", startIndex);

        String quote = string.substring(startIndex, endIndex).trim();
        String[] quoteTable = quote.split("</th></tr>");

        return quoteTable[1].trim();
    }

    private static String[] createDataArray(String input) {
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

    private static int countClosingBraces(String input) {
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

    private String writeNewData(EnterTheData enteredData) throws IOException {
        String[] dataTransaction = enteredData.enteredData();
        String newRow = "<tr><td>" + dataTransaction[0] + "</td><td>" +
                dataTransaction[1] + "</td><td>" + dataTransaction[2] + "</td></tr>\n";

        return newRow;
    }

    private void writeToFile(String data) {
        try {

            this.write(this.read() + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class TransactionsDataHtmlArray {
    private static String[][] getDataArray(String[] data) {

        String[][] result = new String[counterLines(data)][3];
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