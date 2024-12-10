package Lesson1;

public class Arrays_of_Strings {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 10;
        String[] strings = new String[3];
        strings[0] = "Привет";
        strings[1] = "Пока";
        strings[2] = "Джава";

        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);

        for (String element : strings) {
            System.out.println(element);
        }

        int[] numbers1 = {10, 20, 30};
        int sum = 0;
        for (int element : numbers1) {
            sum = sum + element;
        }
        System.out.println(sum);
    }
}
