package point01;

import javax.swing.*;
import java.io.File;

public class FileDialogOpener {

    public File openFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите файл для работы");

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Выбран файл: " + selectedFile.getAbsolutePath());
            return selectedFile;
        } else {
            System.out.println("Выбор файла отменен.");
            return null;
        }
    }

    public static void main(String[] args) {
        FileDialogOpener dialogOpener = new FileDialogOpener();
        File selectedFile = dialogOpener.openFileDialog();

        if (selectedFile != null) {
            System.out.println("Открыт файл: " + selectedFile.getAbsolutePath());
        } else {
            System.out.println("Файл не был выбран.");
        }
    }
}
