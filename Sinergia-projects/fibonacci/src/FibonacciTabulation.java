public class FibonacciTabulation {
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n должно быть неотрицательным");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("F(" + n + ") = " + fibonacci(n));
    }
}

