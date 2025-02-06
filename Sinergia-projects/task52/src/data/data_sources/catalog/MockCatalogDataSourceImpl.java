package data.data_sources.catalog;

import data.moduls.Product;

import java.util.List;


public class MockCatalogDataSourceImpl extends CatalogDataSource {

    private final List<Product> products;

    public MockCatalogDataSourceImpl() {
        this.products = ProductLoader.loadProducts();
    }

    @Override
    public List<Product> getCatalog() {
        return products;
    }

}