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
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public void writeHtmlTable(String[][] data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("<html><body><table border='1'>\n");
            for (String[] row : data) {
                if (row != null) {
                    writer.write("<tr>");
                    for (String cell : row) {
                        writer.write("<td>" + (cell != null ? cell : "") + "</td>");
                    }
                    writer.write("</tr>\n");
                }
            }
            writer.write("</table></body></html>");
        }
    }

    public String[][] readHtmlTable() throws IOException {
        String[][] records = new String[100][10];
        int rowIndex = 0;
        boolean inTable = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<table")) {
                    inTable = true;
                } else if (line.contains("</table>")) {
                    inTable = false;
                    break;
                } else if (inTable && line.contains("<tr>")) {
                    String[] cells = line.replace("<tr>", "").replace("</tr>", "").split("<td>|</td>");
                    records[rowIndex] = new String[cells.length - 1]; // Удаляем пустые элементы
                    for (int i = 1; i < cells.length; i++) {
                        records[rowIndex][i - 1] = cells[i];
                    }
                    rowIndex++;
                }
            }
        }
        return records;
    }

    @Override
    public String writeSumByMont(String[][][] data) {
        StringBuilder result = new StringBuilder();
        result.append("<html><body>");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                String year = data[i][0][1].substring(0, 4);
                int monthIndex = Integer.parseInt(data[i][0][1].substring(5, 7));
                String monthName = monthNames[monthIndex - 1];

                double sum = 0;
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j] != null) {
                        sum += Double.parseDouble(data[i][j][2]);
                    }
                }
                result.append("<h3>").append(monthName).append(" ").append(year).append("</h3>")
                        .append("<p>Итог: ").append(String.format("%.2f", sum)).append("</p>");
            }
        }
        result.append("</body></html>");
        return result.toString();
    }
}
