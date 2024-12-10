import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter boolean expression:");
        String expr = scanner.nextLine(); // input in the format: 1&0

        char x = expr.charAt(0);
        char operator = expr.charAt(1);
        char y = expr.charAt(2);

        boolean xValue = false;
        if (x == '1'){
            xValue = true;
        } else {
            xValue = false;
        }

        boolean yValue = false;
        if (y == '1'){
            yValue = true;
        } else {
            yValue = false;
        }

        if (operator == '&'){
            System.out.println(xValue && yValue);
        } else if (operator == '|') {
            System.out.println(xValue && yValue);
        } else {
            System.out.println("Unknown operator");
        }
    }
}
