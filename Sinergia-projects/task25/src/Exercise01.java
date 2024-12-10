public class Exercise01 {

    public static void main(String[] args) {
        System.out.println("Максимум (целые числа): " + max(15, 23));
        System.out.println("Максимум (вещественные числа): " + max(19.3, 2.30));
        System.out.println("Максимум (строки): " + max("для целых", "вещественных чисел"));
    }

    public static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    public static double max(double x, double y) {
        return (x > y) ? x : y;
    }

    public static String max(String x, String y) {
        return (x.length() > y.length()) ? x : y;
    }
}
