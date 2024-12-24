package point01;

import java.io.*;

public class FileHandler {
    String filePath;
    public static String[] monthNames = {
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    };

    public FileHandler(String filePath) {
        this.filePath = filePath;

    }

    public void run() throws IOException {

    }

    public void write(String content) throws IOException {

    }

    public String read() throws IOException {

        return "";
    }

    public String readListTransactions() throws IOException {

        return "";
    }

    public String readMonthlyReport() throws IOException {

        return "";
    }

    public String writeSumByMont(String[][][] data){

        return "";
    }

    public static String dataListTransactionsToString(String[][] array){
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0) {
                    result = result + "Текущая дата и время: " + array[i][j] + "; \n";
                }
                if (j == 1) {
                    result = result + "Описание сделки: "+ array[i][j] + "; \n";
                }
                if (j == 2) {
                    result = result + "Сумма сделки: " + array[i][j] + "; \n";
                }
            }
        }

        return result.trim();
    }

    public static String dataReportToString(String[][] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0) {
                    result = result + array[i][j] + "; \n";
                }

                if (j == 1) {
                    result = result + "Итог: " + array[i][j] + "; \n";
                }

            }

        }

        return result.trim();
    }

}
