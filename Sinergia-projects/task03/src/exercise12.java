import java.util.Scanner;

public class exercise12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое слово:");
        String str1 = scanner.nextLine();
        int lengthStr1 = str1.length();

        System.out.println("Введите второе слово:");
        String str2 = scanner.nextLine();
        int lengthStr2 = str2.length();

        System.out.println("Введите третье слово:");
        String str3 = scanner.nextLine();
        int lengthStr3 = str3.length();

        int min;
        String strMin;
        if (lengthStr1 < lengthStr2) {
            min = lengthStr1;
            strMin = "Первое слово";
            if (min > lengthStr3) {
                min = lengthStr3;
            }
        } else {
            if (lengthStr2 < lengthStr3) {
                min = lengthStr2;
            } else {
                min = lengthStr3;
            }
        }

        System.out.println(str1.substring(0, min));
        System.out.println(str2.substring(0, min));
        System.out.println(str3.substring(0, min));
    }
}
