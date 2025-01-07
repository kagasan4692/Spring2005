package exercise02;

public class StringBuilderEqualsDebug {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");

        boolean areEqual = sb1.equals(sb2);
        System.out.println("sb1.equals(sb2): " + areEqual);

        StringBuilder sb3 = sb1;
        boolean areSame = sb1.equals(sb3);
        System.out.println("sb1.equals(sb3): " + areSame);

        boolean areContentsEqual = sb1.toString().equals(sb2.toString());
        System.out.println("sb1.toString().equals(sb2.toString()): " + areContentsEqual);
    }
}
