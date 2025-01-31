package data.moduls;

public class Product {
    public final  String id;
    public final  String title;
    public final  String description;
    public final  int price;
    public final  boolean available;
    public int stock;

    public Product(String id, String title, String description, int price, boolean available, int stock) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.available = available;
        this.stock = stock;
    }
}
