public class FibonacciRecursion {
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n должно быть неотрицательным");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // Можно поменять на любое число
        System.out.println("F(" + n + ") = " + fibonacci(n));
    }
}
