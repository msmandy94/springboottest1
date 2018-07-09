package com.springboottest1.Controller;

import com.springboottest1.Entity.Product;
import com.springboottest1.Service.ProductCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/productcatalog")
public class ProductCatalogController {
    private final Logger log = LoggerFactory.getLogger(ProductCatalogController.class);

    @Autowired
    private ProductCatalogService productCatalogService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Product> getAllProducts(){
        log.debug("REST request to get all products : {}");
        return productCatalogService.getAllProducts();
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
        log.debug("REST request to get product by id: {}", id);
        return productCatalogService.getProductById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable("id") int id){
        log.debug("REST request to delete product by id: {}", id);
        productCatalogService.removeProductById(id);
    }

    @RequestMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void updateProductById(@RequestBody Product product){
        log.debug("REST request to update product by id: {}", product.toString());
        productCatalogService.updateProduct(product);
    }

    @RequestMapping(value = "/insert",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public void insertProductToDb(@RequestBody Product product){
        log.debug("REST request to insert product: {}", product.toString());
        productCatalogService.insertProductToDb(product);
    }
}
