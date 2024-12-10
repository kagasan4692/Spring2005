public class exercise7 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;

//        int x = 5;
//        int y = 2;

        double exponentiation1 = Math.pow(x, y);
        double exponentiation2 = Math.pow(y, x);

        if (exponentiation1 > exponentiation2) {
            System.out.println("x в степени y больше, чем y  в степени x");
        } else {
            System.out.println("y в степени x больше, чем x в степени y");
        }
    }
}
