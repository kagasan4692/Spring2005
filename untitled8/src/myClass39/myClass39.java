package myClass39;

public class myClass39 {
    public static void main(String[] args) {
        Speakable speakable = new Cat();
        sayHello(speakable);


    }

    public static void sayHello(Speakable speakable) {
        speakable.introduceYourself();
        speakable.speak("Hello ");
    }
}
