package data.data_sources.catalog;

import data.moduls.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductLoader {
    private static final String FILE_NAME = "products.txt";

    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 6) continue;

                String id = parts[0];
                String title = parts[1];
                String description = parts[2];
                int price = Integer.parseInt(parts[3]);
                boolean available = Boolean.parseBoolean(parts[4]);
                int stock = Integer.parseInt(parts[5]);

                products.add(new Product(id, title, description, price, available, stock));
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке товаров: " + e.getMessage());
        }
        return products;
    }
}
