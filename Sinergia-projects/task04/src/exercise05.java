public class exercise05 {
    public static void main(String[] args) {

        float floatA = 1000115F;
        double doubleA = floatA;
//  OR
        double doubleB = Double.valueOf(floatA);
        System.out.println(doubleA);
        System.out.println(doubleB);
    }
}
