package com.fpmislata.grup4pawparadise.business.entity;

import java.math.BigDecimal;

public class Product {
    int id;
    String name;
    BigDecimal price;
    int stock;
    String description;
    
    
    public Product(int id, String name, String price, int stock, String description) {
        this.id = id;
        this.name = name;
        this.price = new BigDecimal(price);
        this.stock = stock;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }
}
