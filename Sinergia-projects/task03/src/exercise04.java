import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое слово:");
        String str1 = scanner.nextLine();
        int lengthStr1 = str1.length();

        System.out.println("Введите второе слово (не равное по длине первому слову):");
        String str2 = scanner.nextLine();
        int lengthStr2 = str2.length();

        System.out.println("Введите третье слово: (не равное по длине первому и второиу слову)");
        String str3 = scanner.nextLine();
        int lengthStr3 = str3.length();

        int min;
        String strMin;
        if (lengthStr1 < lengthStr2) {
            min = lengthStr1;
            strMin = "Первое слово";
            if (min > lengthStr3) {
                min = lengthStr3;
                strMin = "Третье слово";
            }
        } else {
            if (lengthStr2 < lengthStr3) {
                min = lengthStr2;
                strMin = "Второе слово";
            } else {
                min = lengthStr3;
                strMin = "Третье слово";
            }
        }
        System.out.println(strMin + " имеет минимальную длину = " + min);
    }
}