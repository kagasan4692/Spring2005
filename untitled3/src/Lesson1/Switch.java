package Lesson1;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age");
        String age = scanner.nextLine();
        switch (age) {
            case "zero":
                System.out.println("You were born");
                break;
            case "seven":
                System.out.println("You went to school");
                break;
            case "eighteen":
                System.out.println("You finished school");
                break;
            default:
                System.out.println("You are a different age");
        }
    }
}
