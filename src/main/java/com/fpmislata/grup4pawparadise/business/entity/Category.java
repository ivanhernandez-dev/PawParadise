package com.fpmislata.grup4pawparadise.business.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    int id;
    String name;
    List<Category> categories;
    List<Product> products;
    
    public Category(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Category(int id, String name, List<Category> categories, List<Product> products) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.products = products;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.categories = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
