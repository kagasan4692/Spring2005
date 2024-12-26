package myClass39;

public class Cat implements Speakable {

    @Override
    public void speak(String str) {
        System.out.println(str + "Mya mya");
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm the cat");
    }
}
