import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int max;
//        if (x > y && x > z) {
//            max = x;
//        } else {
//            if (y > z && y > x) {
//                max = y;
//            } else {
//                max = z;
//            }
//        }

       max = (x > y && x > z) ? x : (y > z && y > x) ? y : z;

        System.out.println(max);
    }
}
