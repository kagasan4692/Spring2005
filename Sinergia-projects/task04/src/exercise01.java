public class exercise01 {
    public static void main(String[] args) {
        byte byteA = 100;
        short shortA = byteA;

        System.out.println(shortA);

        // OR

        byte byteB = 100;
        short shortB = Short.valueOf(byteB);

        System.out.println(shortB);
    }

}
