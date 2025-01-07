package exercise01;

public class StringEqualsDebug {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello"); // Создаём новую строку
        String str4 = "World";

        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.equals(str4): " + str1.equals(str4));

        System.out.println("str1.equals(null): " + str1.equals(null));
    }
}
