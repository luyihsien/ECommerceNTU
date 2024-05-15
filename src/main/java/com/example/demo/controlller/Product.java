package com.example.demo.controlller;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
// This annotation marks the class as an entity bean, so it must have a no-argument constructor that is visible with at least protected scope.
public class Product {
    @Id  // Marks a field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    private long id;

    private String name;

    private double price;

    // Getter and setter for 'id'
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for 'price'
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}