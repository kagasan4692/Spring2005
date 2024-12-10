import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fileNames = new String[5];
        System.out.println("Введите 5 названий файлов:");
        for (int i = 0; i < fileNames.length; i++) {
            System.out.print("Файл " + (i + 1) + ": ");
            fileNames[i] = scanner.nextLine();
        }

        for (int i = 0; i < fileNames.length; i++) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(fileNames[i]));
                for (int j = 0; j < fileNames.length; j++) {
                    writer.write(fileNames[j]);
                    writer.newLine();
                }
                System.out.println("Названия файлов записаны в файл: " + fileNames[i]);
            } catch (IOException e) {
                System.out.println("Ошибка при работе с файлом " + fileNames[i] + ": " + e.getMessage());
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка при закрытии файла " + fileNames[i] + ": " + e.getMessage());
                    }
                }
            }
        }

        scanner.close();
    }
}
