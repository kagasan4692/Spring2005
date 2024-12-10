import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Вводите 10 строк");
        int i = 0;
        while (i < 10){
            i++;
            String str = scanner.nextLine();
            if (str.contains("!")){
                System.err.println(str);
            }
        }

    }
}
