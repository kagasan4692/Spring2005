import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите простое предложение");
        String row = scanner.nextLine();

        char[] rowArray = row.toCharArray();
        int j = 0;

        for (int i = 0; i < rowArray.length; i++) {
            if (rowArray[i] == ' ' || rowArray[i] == '.') {

                if (i - j > 2) {            // учтем что в предложении могут быть слова менее 2 букв.
                    rowArray[i - 2] = '*';
                }
                rowArray[i - 1] = '*';
                j = i;
            }
        }

        for (int i = 0; i < rowArray.length; i++) {
            System.out.print(rowArray[i]);
        }
    }

}
