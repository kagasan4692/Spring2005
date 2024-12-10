package exercise03;

public class Character {
    private String name;
    private int health;
    private int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String toString() {
        return "Name: " + name + ", Health: " + health + ", Attack Power: " + attackPower;
    }
}
