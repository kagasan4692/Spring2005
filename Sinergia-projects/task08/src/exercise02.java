import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

//        if (x > y) {
//            System.out.println("x > y");
//        } else {
//            System.out.println("x <= y");
//        }

        String answer = x > y ? "икс > игрек" : "икс <= чем игрек";

        System.out.println(answer);
    }
}
