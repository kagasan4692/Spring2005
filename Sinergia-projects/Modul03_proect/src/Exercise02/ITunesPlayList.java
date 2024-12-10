package Exercise02;

import java.io.IOException;
import java.util.Scanner;

public class ITunesPlayList {
    public static void playList(String quote) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ITunesData iTunesData = new ITunesData();
        String[][] playList = iTunesData.getITunesData(quote);
        printPlayList(playList);

        System.out.println("Введите номер нужного трека:");
        int counter = scanner.nextInt();
        String[] trekData = playList[counter - 1];


        FileDownloader saveFile = new FileDownloader();
        saveFile.saveMedia(trekData);
    }

    private static void printPlayList(String[][] array) {
        System.out.println();
        boolean error = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] != null && array[i][1] != null && array[i][2] != null) {
                System.out.print((i + 1) + ". ");
                System.out.print("Артист: " + array[i][0] + ", ");
                System.out.print("Название трека: " + array[i][1] + ". ");
//            System.out.println();
//            System.out.print(array[i][2]);
                System.out.println();

                error = false;
            }
        }
        System.out.println();

        if (error) {
            System.out.println("Непредвиденная ошибка!");
            System.exit(0);
        }
    }


}
