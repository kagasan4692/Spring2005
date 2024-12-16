package point01;

import java.io.*;

public class CsvFileHandler extends FileHandler {
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
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public String[][] readCsv() throws IOException {
        String[][] records = new String[100][10]; // Ограничение на 100 строк и 10 колонок
        int rowIndex = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                records[rowIndex] = new String[splitLine.length];
                for (int i = 0; i < splitLine.length; i++) {
                    records[rowIndex][i] = splitLine[i];
                }
                rowIndex++;
            }
        }
        return records;
    }

    public void writeCsv(String[][] data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    writer.write(String.join(",", data[i]));
                    writer.newLine();
                }
            }
        }
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
                result.append(separator).append("\n")
                        .append(monthName).append(" ").append(year).append("\n")
                        .append("Итог: ").append(String.format("%.2f", sum)).append("\n");
            }
        }
        return result.toString();
    }

    private static Double parseNumberFormat(String strNumber) {
        strNumber = strNumber.replace(',', '.');
        return Double.parseDouble(strNumber);
    }
}
