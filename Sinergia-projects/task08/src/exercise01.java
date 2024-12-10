import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
//        int max;
//        if (x > y) {
//            max = x;
//        } else {
//            max = y;
//        }
        int max = x > y ? x : y;

        System.out.println("Max is " + max);
    }
}
