import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class point02 {
    public static void main(String[] args) throws IOException {

        for (int i = 1; i < 32; i++) {

            File file = new File("nasa_pictures/" + i + ".txt");

            if (file.exists()) {
                Scanner scannerText = new Scanner(file);
                String line = scannerText.nextLine();

                appendImageToFile("nasa_pictures/" + i + ".jpg");
                appendTextToFile(line);
            }

        }
    }

    public static void appendTextToFile(String text) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("index.html", true))) {
            text = "<div style='width: 600px; border-bottom: 2px solid black; border-left: 2px solid black; border-right: 2px solid black;'>" + text
                    + "</div><div style='height: 20px; width: 600px;'></div>";
            writer.write(text);
            writer.newLine();

        }
    }

    public static void appendImageToFile(String imagePath) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("index.html", true))) {
            imagePath = "<img src=" + imagePath + " alt=Image style='width: 600px'>";
            String text = "<div style='width: 600px; border-top: 2px solid black; border-left: 2px solid black; border-right: 2px solid black'>"
                    + imagePath + "</div><div style='height: 10px; width: 600px; border-left: 2px solid black; border-right: 2px solid black;'></div>";
            writer.write(text);
            writer.newLine();

        }
    }
}
