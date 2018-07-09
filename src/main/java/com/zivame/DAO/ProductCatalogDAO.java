package com.zivame.DAO;

import com.zivame.Entity.Product;

import java.util.Collection;

/**
 * Created by mandeepsingh on 4/14/18.
 */
public interface ProductCatalogDAO {
    Collection<Product> getAllProducts();

    Product getProductById(int id);

    void removeProductById(int id);

    void updateProduct(Product product);

    void insertProductToDb(Product product);
}
