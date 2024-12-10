public class Exercise01 {
        public static void main(String[] args){

        System.out.println(divisionByTwo(6, 3, 2));
        System.out.println(divisionByTwo(10, 5, 2));
        System.out.println(divisionByTwo(8, 4, 2));
        System.out.println(divisionByTwo(7, 5, 3));
    }

    private static int divisionByTwo(int a, int b, int c) {
        if (a % b == 0 && a % c == 0) {
            return a;
        } else if (b % a == 0 && b % c == 0) {
            return b;
        } else if (c % a == 0 && c % b == 0) {
            return c;
        } else {
            return -1;
        }
    }
}
