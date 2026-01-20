package com.vgutierrez.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vgutierrez.product.model.Product;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @GetMapping()
    public Product getProduct(@RequestParam String id) {
        return new Product(id, "Sample Product", 99.99, "Instance 2");
    }
}
