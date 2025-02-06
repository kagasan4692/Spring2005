package data.data_sources.catalog;

import data.moduls.Product;
import java.util.List;

public abstract class CatalogDataSource {
       public abstract List<Product> getCatalog();
}
