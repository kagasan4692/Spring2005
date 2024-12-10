
import java.io.*;
import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) throws IOException {
        String nameFile1 = "fistFile.txt";

        InputStream stream = new FileInputStream(nameFile1);
        Scanner scanner = new Scanner(stream);
        String nameFile2 = scanner.nextLine();

        stream = new FileInputStream(nameFile2);
        scanner = new Scanner(stream);
        String nameFile3 = scanner.nextLine();

        System.out.println("введите латинскую букву");
        char word =(char) System.in.read();

        PrintWriter streamPt = new PrintWriter(nameFile3);
        streamPt.println(word);
        streamPt.close();

        System.out.println("Буква : " +  word + " записана в файл " + nameFile3);
    }
}
