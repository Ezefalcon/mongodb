package com.mongo.demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("producto")
public class Product {
    private String id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;
}
