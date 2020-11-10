package com.mongo.demo.controller;

import com.mongo.demo.model.Product;
import com.mongo.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("producto")
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return this.productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestParam("id") String id, @RequestBody Product product) {
        if(this.productRepository.existsById(id)) {
            return this.productRepository.save(product);
        } else throw new IllegalArgumentException();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@RequestParam("id") String id) {
        this.productRepository.deleteById(id);
    }
}
