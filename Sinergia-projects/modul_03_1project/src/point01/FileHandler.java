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

    public void write(String content) throws IOException {

    }

    public String read() throws IOException {

        return "";
    }

    public String writeSumByMont(String[][][] data){

        return "";
    }
}
