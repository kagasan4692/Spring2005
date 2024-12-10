import java.io.FileReader;
import java.io.IOException;

public class Exercise02 {
    public static void main(String[] args) {
        // Checked исключение
        try {
            readFile("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("Обработано checked исключение: " + e.getMessage());
        }

        // Unchecked исключение
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Обработано unchecked исключение: " + e.getMessage());
        }
    }

    // Метод с checked исключением
    public static void readFile(String fileName) throws IOException {
        FileReader file = new FileReader(fileName); // Может выбросить IOException
    }

    // Метод с unchecked исключением
    public static void divide(int a, int b) {
        int result = a / b; // Может выбросить ArithmeticException
    }
}
