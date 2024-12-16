package point01;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        String[][] asd = readCsv(content);

    }

    public static String readCsv(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.csv"))) {
            for (int i = 0; i < content.length; i++) {
                if (content[i] != null) {
                    writer.write(String.join(",", content[i]));
                    writer.newLine();
                }
            }
        }
    }
}
