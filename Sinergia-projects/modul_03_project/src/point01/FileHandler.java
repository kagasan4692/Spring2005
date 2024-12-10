package point01;

import java.io.*;

public class FileHandler {
    String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public void write(String content) throws IOException {

    }

    public String read() throws IOException {

        return "";
    }
}

class TxtFileHandler extends FileHandler {

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
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
