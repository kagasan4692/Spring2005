package exercise03;

public class Hero extends Character {
    private String specialAbility;

    public Hero(String name, int health, int attackPower, String specialAbility) {
        super(name, health, attackPower);
        this.specialAbility = specialAbility;
    }

    public String toString() {
        return super.toString() + ", Special Ability: " + specialAbility;
    }
}
