import java.io.File;
import java.io.IOException;

public class exercise05 {
    public static void main(String[] args) throws IOException {
        System.out.println("Создаем 10 000 файлов. Пожалуйста, подождите");
        int i = 1;
        while (i <= 10000) {

            File file = new File("files/" + "example-" + i + ".txt");
            file.createNewFile();
            i++;
        }
        System.out.println("Файлы созданы");
    }
}
