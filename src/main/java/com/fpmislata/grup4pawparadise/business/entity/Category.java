package com.fpmislata.grup4pawparadise.business.entity;

public class Category {
    
    int id;
    String name;
    
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
