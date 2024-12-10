import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) throws IOException {
        Scanner scanner1 = new Scanner(new File("file1.txt"));
        String[] array1 = new String[5];

        for (int i = 0; i < array1.length; i++) {
            String dataLine = scanner1.nextLine();

            array1[i] = dataLine;

        }

        Scanner scanner2 = new Scanner(new File("file2.txt"));
        String[] array2 = new String[5];

        for (int i = 0; i < array2.length; i++) {
            String dataLine = scanner2.nextLine();

            array2[i] = dataLine;

        }

        String[] arrayGeneral = new String[10];

        int j = 0;
        for (int i = 0; i < arrayGeneral.length; i++) {
            if (i < 5){
                arrayGeneral[i] = array1[i];
            } else {
                arrayGeneral[i] = array2[j];
                j++;
            }
        }

//        for (int i = 0; i < arrayGeneral.length; i++) {
//            System.out.println(arrayGeneral[i]);
//        }
    }
}
