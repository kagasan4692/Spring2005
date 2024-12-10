import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные файла в одну строку: имя файла, размер, тип файла, дата создания");

        String input = scanner.nextLine();

//        String input = "berns.txt, 312005, text, 2021-02-05";

        FileInformation fileInformation = new FileInformation(getDataArray(input));

        System.out.println(fileInformation.fileName);
        System.out.println(fileInformation.fileSize);
        System.out.println(fileInformation.fileType);
        System.out.println(fileInformation.creationDate);
    }

    private static String[] getDataArray(String input) {
        StringBuilder inputBuilder = new StringBuilder(input);
        int counterCommas = 0;

        StringBuilder nameBuilder = new StringBuilder();
        StringBuilder longBuilder = new StringBuilder();
        StringBuilder typeBuilder = new StringBuilder();
        StringBuilder dateBuilder = new StringBuilder();

        for (int i = 0; i < inputBuilder.length(); i++) {
            if (inputBuilder.charAt(i) != ',') {
                if (counterCommas == 0) {
                    nameBuilder.append(inputBuilder.charAt(i));

                } else if (counterCommas == 1) {
                    if (inputBuilder.charAt(i) != ' ') {
                        longBuilder.append(inputBuilder.charAt(i));
                    }
                } else if (counterCommas == 2) {
                    if (inputBuilder.charAt(i) != ' ') {
                        typeBuilder.append(inputBuilder.charAt(i));
                    }
                } else if (counterCommas == 3) {
                    if (inputBuilder.charAt(i) != ' ') {
                        dateBuilder.append(inputBuilder.charAt(i));
                    }
                }

            } else {
                counterCommas++;
            }
        }

        String[] newArray = {nameBuilder.toString(), longBuilder.toString(), typeBuilder.toString(), dateBuilder.toString()};

        return newArray;
    }
}
