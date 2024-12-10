import java.io.*;
import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла (например, text.txt):");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            if (file.exists()) {
                String content = readFileContent(fileName);
                System.out.println("Содержимое файла:");
                System.out.println(content);
            } else {
                throw new RuntimeException("Ошибка: Файл не найден!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static String readFileContent(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }
}
