package Lesson1;

public class StringBuilderLesson {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("Hello");
        str1.append(" my").append(" friend");
        String string = str1.toString().toUpperCase();
        System.out.println(string);
    }
}
