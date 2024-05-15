package com.example.demo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }
}
