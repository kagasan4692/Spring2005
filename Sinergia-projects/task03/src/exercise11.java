import java.util.Scanner;

public class exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        boolean anEvenNumber = false;
        boolean aNegativeNumber = false;
        boolean lessThousandNumber = false;

        while (i < 3){
            i++;
            System.out.println("Введите число " + i);
            int num = scanner.nextInt();
            if (num% 2 == 0){
                anEvenNumber = true;
            }

            if (num < 0){
                aNegativeNumber = true;
            }

            if (num < 1000){
                lessThousandNumber = true;
            }

        }

        if (anEvenNumber){
            System.out.println("Среди введенных чисел есть четные");
        }

        if (aNegativeNumber){
            System.out.println("Среди введенных чисел есть отрицательные");
        }

        if (lessThousandNumber){
            System.out.println("Среди введенных чисел есть меньше 1000");
        }
    }
}
