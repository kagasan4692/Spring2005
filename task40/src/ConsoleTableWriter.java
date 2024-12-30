public class ConsoleTableWriter {
    public static void main(String[] args) {

        String[] headers = {"№", "Имя", "Возраст", "Город"};
        String[][] data = {
                {"1", "Алексей", "25", "Москва"},
                {"2", "Мария", "30", "Санкт-Петербург"},
                {"3", "Иван", "22", "Новосибирск"},
                {"4", "Анна", "27", "Казань"}
        };

        printTable(headers, data);
    }

    public static void printTable(String[] headers, String[][] data) {
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                columnWidths[j] = Math.max(columnWidths[j], data[i][j].length());
            }
        }

        printRow(headers, columnWidths);
        printSeparator(columnWidths);

        for (int i = 0; i < data.length; i++) {
            printRow(data[i], columnWidths);
        }
    }

    private static void printRow(String[] row, int[] columnWidths) {
        for (int i = 0; i < row.length; i++) {
            System.out.print("| " + padRight(row[i], columnWidths[i]) + " ");
        }
        System.out.println("|");
    }

    private static void printSeparator(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            System.out.print("|");
            for (int j = 0; j < columnWidths[i] + 2; j++) {
                System.out.print("-");
            }
        }
        System.out.println("|");
    }

    private static String padRight(String text, int length) {
        StringBuilder padded = new StringBuilder(text);
        for (int i = text.length(); i < length; i++) {
            padded.append(" ");
        }

        return padded.toString();
    }
}
