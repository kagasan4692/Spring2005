import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("file.txt"));

        for (int i = 0; i < 10; i++) {
            String dataLine = scanner.nextLine();
            double dataDouble = Double.parseDouble(dataLine);
            if (dataDouble > Math.PI) {
                System.out.println(dataDouble);
            }

        }

    }
}
