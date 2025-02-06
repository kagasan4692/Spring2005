package data.moduls;

public class Product {
    private final String id;
    private final String title;
    private final String description;
    private final int price;
    private int stock;

    public Product(String id, String title, String description, int price, int stock) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = Math.max(stock, 0);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = Math.max(stock, 0);
    }
}
