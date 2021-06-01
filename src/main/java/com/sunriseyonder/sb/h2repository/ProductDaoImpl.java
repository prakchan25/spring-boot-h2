package com.sunriseyonder.sb.h2repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunriseyonder.sb.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("ID"));
            product.setName(rs.getString("NAME"));
            product.setColor(rs.getString("COLOR"));
            product.setBrand(rs.getString("BRAND"));
            product.setOperatingSystem(rs.getString("OPERATING_SYSTEM"));
            product.setSoldBy(rs.getString("SOLD_BY"));
            product.setPrice(rs.getBigDecimal("PRICE"));
            product.setAvailableStock(rs.getInt("AVAILABLE_STOCK"));
            return product;
        }
    }

    public int insert(Product product) {
        try {
            return jdbcTemplate.update("INSERT INTO PRODUCT (NAME, COLOR, BRAND,OPERATING_SYSTEM,SOLD_BY,PRICE,AVAILABLE_STOCK) " + "values(?,?,?,?,?,?,?)",
                    new Object[] { product.getName(), product.getColor(),product.getBrand(),product.getOperatingSystem(),product.getSoldBy(),product.getPrice(),product.getAvailableStock() });
        }catch (Exception ex){
            logger.error("Error inserting :: "+ex.getCause());
        }
       return 0;
    }


}
