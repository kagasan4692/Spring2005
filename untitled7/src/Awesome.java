import java.util.Scanner;

public class Awesome {
    String name;
    String string;
    Scanner scanner;

    Awesome(){
        this.scanner = new Scanner(System.in);
        System.out.println("default input: ");
        this.string = scanner.nextLine();
    }

    Awesome(String inputString) {
        this.string = inputString;
        this.scanner = new Scanner(System.in);
    }

    Awesome(int inputInt) {
        this.string = String.valueOf(inputInt);
        this.scanner = new Scanner(System.in);
    }

    public void printAwesome() {
        System.out.println(this.string);
    }

    public void readString(){
        System.out.println(this.name + " input: ");
        this.string = scanner.nextLine();
    }
}

