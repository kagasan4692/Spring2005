import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое число с нулями : ");
        String number = scanner.nextLine();

        int j = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') {
                j++;
            }
        }
        System.out.println("В числе " + number + " содержится " + j + " нуля(ей)");
    }
}
