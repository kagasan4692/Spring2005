public class Exercise03 {

    public static void main(String[] args) {

        System.out.println(join("который ", "будет!"));
        System.out.println(join("который ", "будет ", "возвращать!"));
        System.out.println(join("который ", "будет ", "возвращать ", "логическое!"));
    }

    public static String join(String s1, String s2) {
        return s1 + s2;
    }

    public static String join(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }

    public static String join(String s1, String s2, String s3, String s4) {
        return s1 + s2 + s3 + s4;
    }
}
