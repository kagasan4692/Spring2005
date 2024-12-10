import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числа через пробел:");

        String input = scanner.nextLine();
        String[] numberStrings = input.split(" ");
        String result = "Нет четных чисел";
        if (numberStrings.length > 1){
            int number;
            for (int i = 0; i < numberStrings.length; i++) {
                number = Integer.parseInt(numberStrings[i]);

                if (number % 2 == 0) {
                    result = "Первое четное число: " + number;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}
