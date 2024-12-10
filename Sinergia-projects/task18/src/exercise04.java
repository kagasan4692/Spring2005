import java.io.File;

public class exercise04 {
    public static void main(String[] args) {
        File dir = new File("text-files");
        File[] files = dir.listFiles();

        int declaredFields = 3;
        String[][] fileInformation = new String[files.length][declaredFields];

        for (int i = 0; i < files.length; i++) {
            fileInformation[i] = infoFile(files, i);
        }

        printingTwoDimensionalArray(fileInformation);

    }

    private static String[] infoFile(File[] files, int i) {
        String[] newArray = {files[i].getName(), files[i].getAbsolutePath(), String.valueOf(files[i].length())};

        return newArray;
    }

    private static void printingTwoDimensionalArray(String[][] filesArray) {
        for (int i = 0; i < filesArray.length; i++) {
            System.out.println("Информация о Файле № " + (i + 1) + " :");
            for (int j = 0; j < filesArray[i].length; j++) {
                System.out.println(filesArray[i][j]);
            }
            System.out.println("---------------------");
        }
    }

}
