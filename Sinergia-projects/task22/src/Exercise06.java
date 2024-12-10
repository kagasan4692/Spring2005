import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое целое число, кроме 0:");
        String number = scanner.nextLine();

        int lastOne = wordDeclensionConditions(number)[0];
        int lastTwo = wordDeclensionConditions(number)[1];

        String ending;
        if (lastOne == 1 && lastTwo != 11) {
            ending = "программист";
        } else if ((lastOne == 2 || lastOne == 3 || lastOne == 4) &&
                !(lastTwo >= 12 && lastTwo <= 14)) {
            ending = "программиста";
        } else {
            ending = "программистов";
        }

        System.out.println(number + " " + ending);
    }

    private static int[] wordDeclensionConditions(String number) {
        int length = number.length();
        int lastOneNumber, lastTwoNumber;
        if (length == 1) {
            lastOneNumber = Character.getNumericValue(number.charAt(0));
            lastTwoNumber = Character.getNumericValue(number.charAt(0));
        } else {
            lastOneNumber = Character.getNumericValue(number.charAt(length - 1));
            lastTwoNumber = Character.getNumericValue(number.charAt(length - 2)) * 10 + Character.getNumericValue(number.charAt(length - 1));
        }

        int[] result = new int[2];
        result[0] = lastOneNumber;
        result[1] = lastTwoNumber;

        return result;
    }
}
