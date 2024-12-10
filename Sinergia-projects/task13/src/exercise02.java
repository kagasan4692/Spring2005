public class exercise02 {
    public static void main(String[] args) {
        double i = -0.9;
        do {
            i = format(i);
            if (i == 0) {
                i = Math.abs(i);
            }
            System.out.println(i);
            i = i + 0.1;
        } while (i <= 0.9);
    }

    private static double format(double number) {

        return Math.ceil(number * 10) / 10;
    }
}
