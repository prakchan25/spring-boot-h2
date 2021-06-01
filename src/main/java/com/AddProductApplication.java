package com;

import com.sunriseyonder.sb.h2repository.ProductDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddProductApplication{

    public static void main(String[] args) {
        SpringApplication.run(AddProductApplication.class, args);
    }

}
