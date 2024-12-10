import java.util.Scanner;

public class exercise10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввудите заглавную латинскую букву");
        int latLiter = scanner.next().charAt(0);

        int i = 64;
        int n = 0;
        while (i < 90){
            i++;
            n++;
            char liter = (char) i;
            if (liter == latLiter){
                System.out.println(n);
            }
        }
    }
}
