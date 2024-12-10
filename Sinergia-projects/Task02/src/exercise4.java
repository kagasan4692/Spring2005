public class exercise4 {
    public static void main(String[] args) {
        int a = 2;
        int n = 10;
        double exponentiation = Math.pow(a, n);

        if (exponentiation < 512) {
            System.out.println("Pentium 2");
        } else {
            System.out.println("ARM");
        }
    }
}
