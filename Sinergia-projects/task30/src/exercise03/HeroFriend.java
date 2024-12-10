package exercise03;


public class HeroFriend extends Character {
    private String supportiveAbility;

    public HeroFriend(String name, int health, int attackPower, String supportiveAbility) {
        super(name, health, attackPower);
        this.supportiveAbility = supportiveAbility;
    }

    public String toString() {
        return super.toString() + ", Supportive Ability: " + supportiveAbility;
    }
}
