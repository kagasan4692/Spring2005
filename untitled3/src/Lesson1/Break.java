package Lesson1;

public class Break {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
            if (i == 150) {

                break;
            }
        }
    }
}
