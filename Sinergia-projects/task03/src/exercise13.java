import java.util.Scanner;

public class exercise13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите слово:");
        String str = scanner.nextLine();

        int i = 0;
        int resultPlayer1 = 0;
        int resultPlayer2 = 0;
        while (i < 2) {
            i++;
            System.out.println("Игрок" + i + " Введите индексы части слова");
            System.out.println("первый индекс: ");
            int index1 = scanner.nextInt();
            System.out.println("второй индекс: ");
            int index2 = scanner.nextInt();

            String strPart = str.substring(index1, index2);

            if (i == 1){
                resultPlayer1 = strPart.length();
            }

            if (i == 2){
                resultPlayer2 = strPart.length();
            }

            System.out.println(strPart);
        }

        if (resultPlayer1 > resultPlayer2){
            System.out.println("Победил игрок 1");
        }

        if (resultPlayer2 > resultPlayer1){
            System.out.println("Победил игрок 2");
        }

        if (resultPlayer2 == resultPlayer1){
            System.out.println("Ничья");
        }
    }
}
