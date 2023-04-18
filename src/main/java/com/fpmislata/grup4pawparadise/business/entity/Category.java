package com.fpmislata.grup4pawparadise.business.entity;

import java.util.List;

public class Category {
    int id;
    String name;
    List<Product> products;
    
    public Category(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
