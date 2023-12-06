package com.example.demo.controlller;

//import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CartController {
    private BankAccount account = new BankAccount("123456789", 1000);
    @PostMapping("/api/cart")
    public ResponseEntity<String> addToCart(@RequestBody Product product) {
        if (account.withdraw(product.getPrice())) {
            return ResponseEntity.ok("Product added to cart: " + product.getName() + ". New balance: " + account.getBalance());
        } else {
            return ResponseEntity.badRequest().body("Insufficient funds to add product to cart: " + product.getName());
        }
    }
//@PostMapping("/api/cart")
//public ResponseEntity<String> addToCart(@RequestBody Product product) {
//    if (account.withdraw(product.getPrice())) {
//        String message = "Product added to cart: " + product.getName() + ". New balance: " + account.getBalance();
//        return ResponseEntity.ok(message);
//    } else {
//        String errorMessage = "Insufficient funds to add product to cart: " + product.getName();
//        return ResponseEntity.badRequest().body(errorMessage);
//    }
//}
//@RestController
//public class CartController {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    private BankAccount account = new BankAccount("123456789", 1000);
//
//    @PostMapping("/api/cart")
//    public ResponseEntity<String> addToCart(@RequestBody Product product) {
//        if (account.withdraw(product.getPrice())) {
//            //product.setPrice(100);
//            p1roductRepository.save(product);
//            String message = "Product added to cart: " + product.getName() + ". New balance: " + account.getBalance();
//            return ResponseEntity.ok(message);
//        } else {
//            String errorMessage = "Insufficient funds to add product to cart: " + product.getName();
//            return ResponseEntity.badRequest().body(errorMessage);
//        }
//    }
//}

}
class Product {
    private long id;

    private String name;

    private double price;

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

