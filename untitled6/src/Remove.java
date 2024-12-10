import java.io.IOException;
import java.nio.file.*;

public class Remove {
    public static void main(String[] args) throws IOException {
        // create object of Path
        for (int i = 347129; i < 999999; i++){

            Path path = Paths.get("C:/Users/kagasan-test/IdeaProjects/Sinergia-projects/task12/" + i + " example.txt");
            System.out.println(path);
            System.out.println("Файл " + i + "удален");
            try {

                Files.delete(path);
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }


    }
}
