package exercise03;

public class Villain extends Character {
    private String evilPlan;

    public Villain(String name, int health, int attackPower, String evilPlan) {
        super(name, health, attackPower);
        this.evilPlan = evilPlan;
    }

    public String toString() {
        return super.toString() + ", Evil Plan: " + evilPlan;
    }
}
