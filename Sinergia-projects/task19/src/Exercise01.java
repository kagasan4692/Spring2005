public class Exercise01 {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 20;

        int max = maximum(number1, number2);

        System.out.println(max);
    }

    private static int maximum(int a, int b) {

        return a < b ? b : a;
    }

}
