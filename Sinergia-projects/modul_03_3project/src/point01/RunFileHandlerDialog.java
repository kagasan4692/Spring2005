package point01;

import java.io.File;
import java.io.IOException;

public class RunFileHandlerDialog {
    public static void main(String[] args) throws IOException {

        FileDialogOpener dialogOpener = new FileDialogOpener();
        File selectedFile = dialogOpener.openFileDialog();

        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            FileHandler fileHandler;

            if (filePath.endsWith(".csv")) {
                fileHandler = new CsvFileHandler(filePath);
            } else if (filePath.endsWith(".html")) {
                fileHandler = new HtmlFileHandler(filePath);
            } else if (filePath.endsWith(".txt")) {
                fileHandler = new TxtFileHandler(filePath);
            } else {
                throw new IllegalArgumentException("Неверный тип файла! Поддерживаются только CSV, HTML и TXT.");
            }

            System.out.println("Вы работаете с файлом: " + filePath);
            System.out.println(fileHandler.readListTransactions());
        } else {
            System.out.println("Файл не был выбран.");
        }
    }
}
