package myClass39;

public class Donkey implements Speakable {

    @Override
    public void speak(String str) {
        System.out.println(str + "Ia Ia");
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm the donkey");
    }
}
