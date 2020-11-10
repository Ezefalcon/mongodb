package com.mongo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("ventas")
@Data
public class Sale {
    private String id;
    private List<Product> productList;
    private String direction;

    @JsonIgnore
    public double getTotalPrice() {
        return productList.stream()
                .map(Product::getPrice)
                .reduce(Double::sum)
                .orElse(0D);
    }
}
