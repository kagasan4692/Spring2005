package exercise02;

public class Flower {
    private String country;
    private int shelfLifeDays;
    private double price;

    private static int totalSold = 0;

    public Flower(String country, int shelfLifeDays, double price) {
        this.country = country;
        this.shelfLifeDays = shelfLifeDays;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalSold() {
        return totalSold;
    }

    public void sell() {
        totalSold++;
    }
}

class Rose extends Flower {
    public Rose(String country, int shelfLifeDays, double price) {
        super(country, shelfLifeDays, price);
    }
}

class Carnation extends Flower {
    public Carnation(String country, int shelfLifeDays, double price) {
        super(country, shelfLifeDays, price);
    }
}

class Tulip extends Flower {
    public Tulip(String country, int shelfLifeDays, double price) {
        super(country, shelfLifeDays, price);
    }
}

class Lily extends Flower {
    public Lily(String country, int shelfLifeDays, double price) {
        super(country, shelfLifeDays, price);
    }
}
