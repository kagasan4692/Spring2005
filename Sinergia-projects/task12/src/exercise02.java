import java.io.File;
import java.io.IOException;

public class exercise02 {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 1000000; i++) {
            File f = new File(i + " example.txt");
            f.createNewFile();
            System.out.println("Создан " + i);
        }

    }
}
// ДА получилось. НО очень... очень долго! Задействованы были все ресурсы компьютера.
// И удалить этот миллион файлов оказалось целой проблемой!