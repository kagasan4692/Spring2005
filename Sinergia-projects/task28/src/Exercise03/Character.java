package Exercise03;

public class Character {
    private String name;
    private int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void introduce() {
        System.out.println("Я персонаж по имени " + name + " с уровнем здоровья " + health + ".");
    }
}

class MainHero extends Character {
    private String specialAbility;

    public MainHero(String name, int health, String specialAbility) {
        super(name, health);
        this.specialAbility = specialAbility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void useSpecialAbility() {
        System.out.println(getName() + " использует свою особую способность: " + specialAbility + "!");
    }

    @Override
    public void introduce() {
        System.out.println("Я главный герой по имени " + getName() + " с уровнем здоровья " + getHealth() +
                ". Моя особая способность: " + specialAbility + ".");
    }
}

class Villain extends Character {
    private String evilPlan;

    public Villain(String name, int health, String evilPlan) {
        super(name, health);
        this.evilPlan = evilPlan;
    }

    public String getEvilPlan() {
        return evilPlan;
    }

    public void executeEvilPlan() {
        System.out.println(getName() + " воплощает свой злодейский план: " + evilPlan + "!");
    }

    public void introduce() {
        System.out.println("Я злодей по имени " + getName() + " с уровнем здоровья " + getHealth() +
                ". Мой коварный план: " + evilPlan + ".");
    }
}

class HeroFriend extends Character {
    private String supportiveSkill;

    public HeroFriend(String name, int health, String supportiveSkill) {
        super(name, health);
        this.supportiveSkill = supportiveSkill;
    }

    public String getSupportiveSkill() {
        return supportiveSkill;
    }

    public void supportMainHero() {
        System.out.println(getName() + " помогает главному герою, используя свой навык: " + supportiveSkill + ".");
    }

    public void introduce() {
        System.out.println("Я друг главного героя по имени " + getName() + " с уровнем здоровья " + getHealth() +
                ". Я поддерживаю героя своим навыком: " + supportiveSkill + ".");
    }
}
