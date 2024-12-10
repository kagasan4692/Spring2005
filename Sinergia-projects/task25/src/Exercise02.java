public class Exercise02 {
    public static void main(String[] args) {

        System.out.println("and(true, true): " + and(true, true));
        System.out.println("and(true, false): " + and(true, false));
        System.out.println("and(true, 1): " + and(true, 1));
        System.out.println("and(true, 0): " + and(true, 0));
        System.out.println("and(1, true): " + and(1, true));
        System.out.println("and(0, true): " + and(0, true));
        System.out.println("and(0, false): " + and(0, false));
        System.out.println("and(2, true): " + and(2, true));
    }

    public static boolean and(boolean x, boolean y) {
        return x && y;
    }

    public static boolean and(boolean x, int y) {
        return x && (y != 0);
    }

    public static boolean and(int x, boolean y) {
        return (x != 0) && y;
    }
}
