package com.sunriseyonder.sb.service.impl;

import com.sunriseyonder.sb.entity.Product;
import com.sunriseyonder.sb.h2repository.ProductDaoImpl;
import com.sunriseyonder.sb.jsonobjects.addProduct.AddProductRequest;
import com.sunriseyonder.sb.jsonobjects.addProduct.AddProductResponse;
import com.sunriseyonder.sb.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component @Getter
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDaoImpl productDao;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        AddProductResponse response = new AddProductResponse();
        Product product = new Product();
        product.setName(addProductRequest.getProduct().getName());
        product.setColor(addProductRequest.getProduct().getColor());
        product.setBrand(addProductRequest.getProduct().getBrand());
        product.setOperatingSystem(addProductRequest.getProduct().getOperatingSystem());
        product.setSoldBy(addProductRequest.getProduct().getSoldBy());
        product.setAvailableStock(addProductRequest.getProduct().getAvailableStock());
        product.setPrice(BigDecimal.valueOf(addProductRequest.getProduct().getPrice()));
        if(getProductDao().insert(product) == 1) {
            com.sunriseyonder.sb.jsonobjects.common.Product productSchema = new com.sunriseyonder.sb.jsonobjects.common.Product();
            productSchema.setName(product.getName());
            productSchema.setColor(product.getColor());
            productSchema.setBrand(product.getBrand());
            productSchema.setOperatingSystem(product.getOperatingSystem());
            productSchema.setSoldBy(product.getSoldBy());
            productSchema.setAvailableStock(product.getAvailableStock());
            productSchema.setPrice(product.getPrice().doubleValue());
            response.setProduct(productSchema);
        }
        else
            response.setProduct(null);
        return response;
    }
}
