package data.data_sources.catalog;

import data.moduls.Product;

import java.util.ArrayList;

public abstract class CatalogDataSource {
       public abstract ArrayList<Product> getCatalog();
}
