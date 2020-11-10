package com.mongo.demo.controller;

import com.mongo.demo.model.Sale;
import com.mongo.demo.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("ventas")
public class SaleController {
    private final SaleRepository saleRepository;

    @GetMapping
    public List<Sale> findAll() {
        return this.saleRepository.findAll();
    }

    @PostMapping
    public Sale save(@RequestBody Sale sale) {
        return this.saleRepository.save(sale);
    }
}
