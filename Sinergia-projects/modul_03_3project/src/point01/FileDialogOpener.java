package point01;

import javax.swing.*;
import java.io.File;

public class FileDialogOpener {

    public File openFileDialog() {
        // Создаем диалоговое окно выбора файла
        JFileChooser fileChooser = new JFileChooser();

        // Устанавливаем заголовок окна
        fileChooser.setDialogTitle("Выберите файл для работы");

        // Открываем диалоговое окно
        int result = fileChooser.showOpenDialog(null);

        // Обрабатываем выбор пользователя
        if (result == JFileChooser.APPROVE_OPTION) {
            // Получаем выбранный файл
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
