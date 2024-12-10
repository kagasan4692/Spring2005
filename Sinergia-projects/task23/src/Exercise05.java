public class Exercise05 {
    public static void main(String[] args) {
        int number = 1;

        while (true) {
            System.out.println(number);

            if (sumOfDigits(number) == 20) {
                break;
            }

            number++;
        }

        System.out.println("Число, где сумма цифр равна 20: " + number);
    }


    private static int sumOfDigits(int number) {
        String numberStr = String.valueOf(number);
        int sum = 0;
        char[] charArray = numberStr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int digit = Character.getNumericValue(charArray[i]);
            sum = sum + digit;
        }

        return sum;
    }
}
