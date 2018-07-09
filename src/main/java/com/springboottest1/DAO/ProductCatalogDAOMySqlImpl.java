package com.springboottest1.DAO;

import com.springboottest1.Entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by mandeepsingh on 3/14/18.
 */
@Repository("mysql")
public class ProductCatalogDAOMySqlImpl implements ProductCatalogDAO {

    private final Logger log = LoggerFactory.getLogger(ProductCatalogDAOMySqlImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class ProductRowMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product = new Product();
            product.setId(resultSet.getInt("pId"));
            product.setName(resultSet.getString("pName"));
            product.setPrice(resultSet.getInt("pPrice"));
            product.setCategory(resultSet.getString("pCategory"));
            return product;
        }
    }


    @Override
    public Collection<Product> getAllProducts() {
        // SELECT column_name(s) FROM table_name
        List<Product> products = null;
        try{
            final String sql = "SELECT * FROM PRODUCT_CATALOG";
            products = jdbcTemplate.query(sql, new ProductRowMapper());
        } catch (Exception e){
            log.error(e.getMessage(), e);
            //throw e;
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        Product product=null;
        try {
            final String sql = "SELECT * FROM PRODUCT_CATALOG where pId = ?";
            product = jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
            return product;
        } catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return product;
    }

    @Override
    public void removeProductById(int id) {
        // DELETE FROM table_name
        // WHERE some_column = some_value
        try{
            final String sql = "DELETE FROM PRODUCT_CATALOG WHERE pId = ?";
            jdbcTemplate.update(sql, id);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            //throw e;
        }

    }

    @Override
    public void updateProduct(Product product) {
        // UPDATE table_name
        // SET column1=value, column2=value2,...
        // WHERE some_column=some_value
        try {
            final String sql = "UPDATE PRODUCT_CATALOG SET pName = ?, pPrice=?, pCategory = ? WHERE pId = ?";
            final int pId = product.getId();
            final String name = product.getName();
            final int price = product.getPrice();
            final String Category = product.getCategory();
            jdbcTemplate.update(sql, new Object[]{name, price, Category, pId});
        } catch (Exception e){
            log.error(e.getMessage(), e);
            //throw e;
        }
    }

    @Override
    public void insertProductToDb(Product product) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        try{
            final String sql = "INSERT INTO PRODUCT_CATALOG (pId, pName, pPrice, pCategory) VALUES (?, ?, ?, ?)";
            final int pId = product.getId();
            final String name = product.getName();
            final int price = product.getPrice();
            final String Category = product.getCategory();
            jdbcTemplate.update(sql, new Object[]{pId ,name, price, Category});
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            //throw e;
        }
    }
}
