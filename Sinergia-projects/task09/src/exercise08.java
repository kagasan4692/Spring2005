import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 1-ю строку");
        String string1 = scanner.nextLine();
        int lengthStr1 = string1.length();

        System.out.println("Введите 2-ю строку");
        String string2 = scanner.nextLine();
        int lengthStr2 = string2.length();

        System.out.println("Введите 3-ю строку");
        String string3 = scanner.nextLine();
        int lengthStr3 = string3.length();

        System.out.println("Введите 4-ю строку");
        String string4 = scanner.nextLine();
        int lengthStr4 = string4.length();

        System.out.println("Введите 5-ю строку");
        String string5 = scanner.nextLine();
        int lengthStr5 = string5.length();

        System.out.println("Введите 6-ю строку");
        String string6 = scanner.nextLine();
        int lengthStr6 = string6.length();

        System.out.println("Введите 7-ю строку");
        String string7 = scanner.nextLine();
        int lengthStr7 = string7.length();

        System.out.println("Введите 8-ю строку");
        String string8 = scanner.nextLine();
        int lengthStr8 = string8.length();

        System.out.println("Введите 9-ю строку");
        String string9 = scanner.nextLine();
        int lengthStr9 = string9.length();

        System.out.println("Введите 10-ю строку");
        String string10 = scanner.nextLine();
        int lengthStr10 = string10.length();

        System.out.println("Введите максимальную длинну строки");
        int max = scanner.nextInt();

        if (lengthStr1 >= max) {
            System.out.println(string1.substring(0, max));
        } else {
            System.err.println(string1);
        }

        if (lengthStr2 >= max) {
            System.out.println(string2.substring(0, max));
        } else {
            System.err.println(string2);
        }

        if (lengthStr3 >= max) {
            System.out.println(string3.substring(0, max));
        } else {
            System.err.println(string3);
        }

        if (lengthStr4 >= max) {
            System.out.println(string4.substring(0, max));
        }
        else {
            System.err.println(string4);
        }

        if (lengthStr5 >= max) {
            System.out.println(string5.substring(0, max));
        } else {
            System.err.println(string5);
        }

        if (lengthStr6 >= max) {
            System.out.println(string6.substring(0, max));
        } else {
            System.err.println(string6);
        }

        if (lengthStr7 >= max) {
            System.out.println(string7.substring(0, max));
        }
        else {
            System.err.println(string7);
        }

        if (lengthStr8 >= max) {
            System.out.println(string8.substring(0, max));
        } else {
            System.err.println(string8);
        }

        if (lengthStr9 >= max) {
            System.out.println(string9.substring(0, max));
        } else {
            System.err.println(string9);
        }

        if (lengthStr10 >= max) {
            System.out.println(string10.substring(0, max));
        } else {
            System.err.println(string10);
        }

    }
}
