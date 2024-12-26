package myClass39;

public class Dog implements Speakable{
    @Override
    public void speak(String str) {
        System.out.println(str + "Wow wow");
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm the dog");
    }
}
