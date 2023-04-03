package com.fpmislata.grup4pawparadise.business.entity;

import java.math.BigDecimal;

public class Product {
    int id;
    int categoryId;
    String name;
    BigDecimal price;
    int stock;
    String description;
    
    
    public Product(int id, int categoryId, String name, String price, int stock, String description) {
        this.id = id;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }
}
