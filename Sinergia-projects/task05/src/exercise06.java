import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ведите первую строку");
        String string1 = scanner.nextLine();
        int length1 = string1.length();

        System.out.println("Ведите вторую строку");
        String string2 = scanner.nextLine();
        int length2 = string2.length();

        System.out.println("Ведите третью строку");
        String string3 = scanner.nextLine();
        int length3 = string3.length();

        int min, max;

        min = Math.min(length1, length2);
        min = Math.min(min, length3);

        max = Math.max(length1, length2);
        max = Math.max(max, length3);


        int result = max - min;
        System.out.println("Разница по длине составляет:");
        System.out.println(result);
    }
}
