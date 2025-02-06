package data.data_sources.catalog;

import data.moduls.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductLoader {
    private static final String DEFAULT_FILE_NAME = "products.txt";

    public static List<Product> loadProducts() {
        return loadProducts(DEFAULT_FILE_NAME);
    }

    public static List<Product> loadProducts(String filePath) {
        List<Product> products = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("Файл не найден: " + filePath);
            return products;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 5) continue;

                try {
                    String id = parts[0];
                    String title = parts[1];
                    String description = parts[2];
                    int price = Integer.parseInt(parts[3]);
                    int stock = Integer.parseInt(parts[4]);

                    products.add(new Product(id, title, description, price, stock));
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка обработки строки: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке товаров: " + e.getMessage());
        }
        return products;
    }
}
