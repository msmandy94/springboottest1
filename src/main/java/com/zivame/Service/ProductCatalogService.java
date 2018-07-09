package com.zivame.Service;

import com.zivame.DAO.ProductCatalogDAO;
import com.zivame.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductCatalogService {

    @Autowired
    @Qualifier("mysql")
    private ProductCatalogDAO productCatalogDao;

    public Collection<Product> getAllProducts(){
        return this.productCatalogDao.getAllProducts();
    }

    public Product getProductById(int id){
        return this.productCatalogDao.getProductById(id);
    }


    public void removeProductById(int id) {
        this.productCatalogDao.removeProductById(id);
    }

    public void updateProduct(Product product){
        this.productCatalogDao.updateProduct(product);
    }

    public void insertProductToDb(Product product){
        this.productCatalogDao.insertProductToDb(product);
    }

}
