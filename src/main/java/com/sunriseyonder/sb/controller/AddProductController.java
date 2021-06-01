package com.sunriseyonder.sb.controller;

import com.sunriseyonder.sb.jsonobjects.addProduct.AddProductRequest;
import com.sunriseyonder.sb.jsonobjects.addProduct.AddProductResponse;
import com.sunriseyonder.sb.service.ProductService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController@Getter
public class AddProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProductService productService;

    @Autowired
    public AddProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/addProduct/V1")
    public ResponseEntity<AddProductResponse> addProduct(@Valid @RequestBody AddProductRequest addProductRequest){
        logger.info("Adding product ..");
        AddProductResponse response = getProductService().addProduct(addProductRequest);
        if(response == null)
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE); // TODO: create error/warning class
        else
         return ResponseEntity.ok(response);
    }
}
