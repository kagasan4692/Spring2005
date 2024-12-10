import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово :");
        final String word = scanner.nextLine();

        final char[] wordArray = new char[word.length()];
        final char[] tableArray = new char[word.length()];

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = word.charAt(i);
            tableArray[i] = word.charAt(i);
        }

        final int[] i = new int[2];

        for (i[0] = 0; i[0] < wordArray.length; i[0]++) {

            for (i[1] = 0; i[1] < wordArray.length; i[1]++) {
                if (i[0] != i[1]) {
                    if (wordArray[i[0]] == wordArray[i[1]]) {
                        tableArray[i[1]] = '$';
                    }
                }
            }
            wordArray[i[0]] = '@';
        }

//        for (int j = 0; j < tableArray.length; j++) {
//                System.out.println(tableArray[j]);
//        }

        final int[] j = new int[2];
        j[1] = 0;
        for (j[0] = 0; j[0] < tableArray.length; j[0]++) {
            if (tableArray[j[0]] != '$') {
                j[1]++;
            }
        }

        System.out.println("Количество уникальных букв : " + j[1]);
    }
}
