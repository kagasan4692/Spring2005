package Exercise03;

public class Exercise03 {
    public static void main(String[] args) {

        MainHero hero = new MainHero("Эдмунд", 100, "Свет меча");
        Villain villain = new Villain("Гримрок", 150, "Захват мира");
        HeroFriend friend = new HeroFriend("Гримрок", 80, "Лечение");


        hero.introduce();
        hero.useSpecialAbility();

        villain.introduce();
        villain.executeEvilPlan();

        friend.introduce();
        friend.supportMainHero();
    }
}
