package Lesson1;

import java.util.Scanner;

public class Dowhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("enter 5");
            value = scanner.nextInt();
        } while (value != 5);
        System.out.println("entered");
    }
}
