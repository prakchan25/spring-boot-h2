package com.sunriseyonder.sb.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class Product {

    private int id;
    private String name;
    private String color;
    private String brand;
    private String operatingSystem;
    private String soldBy;
    private BigDecimal price;
    private Integer availableStock;

    public Product() {
        super();
    }

}
