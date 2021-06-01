package com.sunriseyonder.sb.service;

import com.sunriseyonder.sb.jsonobjects.addProduct.AddProductRequest;
import com.sunriseyonder.sb.jsonobjects.addProduct.AddProductResponse;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest addProductRequest);
}
