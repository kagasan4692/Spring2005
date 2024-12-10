public class Exercise02 {
    public static void main(String[] args) {
        double number1 = 30.31;
        double number2 = 20.30;

        double max = maximum(number1, number2);

        System.out.println(max);
    }

    private static double maximum(double a, double b) {

        return a < b ? b : a;
    }
}
