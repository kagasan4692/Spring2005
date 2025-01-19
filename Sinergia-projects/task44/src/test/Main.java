package test;

public class Main {

}

class A {}

class B extends A {
    public static void main(String[] args) {
        A a = new B(); // 2
        B b = new B(); // 3
        System.out.println(a + " " + b.toString());
    }
} // 1

