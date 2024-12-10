public class Exercise01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;

        for (int i = 0; i < 10; i++) {

            int result = sum(a, b);
            System.out.println(result);

            a++;
            b++;
        }

    }

    private static int sum(int a, int b) {
        int x = a + b;

        return x;
    }

}
