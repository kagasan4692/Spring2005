public class exercise01 {
    public static void main(String[] args) {
        int number1 = (int) Math.pow(2, 10);
        int number2 = (int) Math.pow(10, 4);

        int min, max;

        if (number1 < number2) {
            min = number1;
            max = number2;
        } else {
            min = number2;
            max = number1;
        }

        for (int i = min; i <= max; i++) {
            System.out.println(i);
        }

    }
}
