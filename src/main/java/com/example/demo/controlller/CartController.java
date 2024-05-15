package com.example.demo.controlller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.controlller.BankAccount;
@RestController
public class CartController {

    private BankAccount account = new BankAccount("123456789", 1000);

    @PostMapping("/api/cart")
    public ResponseEntity<String> addToCart(@RequestBody Product product) {
        //productRepository.save(product);
        if (account.withdraw(product.getPrice())) {
            String message = "Product added to cart: " + product.getName() + ". New balance: " + account.getBalance();
            //String message = "Product added to cart:";
            return ResponseEntity.ok(message);
        } else {
            String errorMessage = "Insufficient funds to add product to cart: " + product.getName();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}

