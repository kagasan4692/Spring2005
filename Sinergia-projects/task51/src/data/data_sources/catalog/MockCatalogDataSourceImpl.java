package data.data_sources.catalog;

import data.moduls.Product;

import java.util.ArrayList;

public class MockCatalogDataSourceImpl extends CatalogDataSource {

    private final ArrayList<Product> products;

    public MockCatalogDataSourceImpl() {
        this.products = ProductLoader.loadProducts();
    }

    @Override
    public ArrayList<Product> getCatalog() {
        return products;
    }

}