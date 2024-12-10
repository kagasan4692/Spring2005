import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fileNames = new String[5];
        System.out.println("Введите 5 названий файлов:");
        for (int i = 0; i < fileNames.length; i++) {
            System.out.print("Файл " + (i + 1) + ": ");
            fileNames[i] = scanner.nextLine();
        }

        for (int i = 0; i < fileNames.length; i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNames[i]))) {
                for (int j = 0; j < fileNames.length; j++) {
                    writer.write(fileNames[j]);
                    writer.newLine();
                }
                System.out.println("Названия файлов записаны в файл: " + fileNames[i]);
            } catch (IOException e) {
                System.out.println("Ошибка при работе с файлом " + fileNames[i] + ": " + e.getMessage());
            }
        }

        scanner.close();
    }
}
