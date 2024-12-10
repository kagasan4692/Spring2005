package exercise03;

public class Exercise03 {
    public static void main(String[] args) {
        Hero hero = new Hero("Arthur", 100, 20, "Fireball");

        Villain villain = new Villain("Dark Lord", 150, 30, "World Domination");

        HeroFriend friend = new HeroFriend("Merlin", 80, 10, "Healing");

        System.out.println(hero.toString());
        System.out.println(villain.toString());
        System.out.println(friend.toString());
    }
}
