import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) throws IOException {
        String[] array1 = scanningFileToArray("file1.txt", 5);
        String[] array2 = scanningFileToArray("file2.txt", 5);

        String[] arrayGeneral = mergeTwoArrays(array1, array2);

        printArray(arrayGeneral);

// Код стал значительно читабельней
    }

    private static String[] mergeTwoArrays(String[] array1, String[] array2) throws IOException{
        String[] newArray = new String[array1.length + array2.length];

        int j = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (i < 5){
                newArray[i] = array1[i];
            } else {
                newArray[i] = array2[j];
                j++;
            }
        }

        return newArray;
    }

    private static String[] scanningFileToArray(String UrlToFile, int lengthArray) throws IOException{
        Scanner scanner1 = new Scanner(new File(UrlToFile));

        String[] array = new String[lengthArray];

        for (int i = 0; i < array.length; i++) {
            String dataLine = scanner1.nextLine();

            array[i] = dataLine;

        }

//        printArray(array);

        return array;
    }

    private static void printArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }
}
