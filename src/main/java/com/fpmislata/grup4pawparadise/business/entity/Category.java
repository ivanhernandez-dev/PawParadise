package com.fpmislata.grup4pawparadise.business.entity;

import java.util.List;

public class Category {

    private final int id;
    private String name;
    private List<Category> categories;
    private String image;

    private final static String DEFAULT_IMAGE_URL = "/img/default.jpg";

    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getImage() {
        if (image == null || image.isEmpty()) {
            return DEFAULT_IMAGE_URL;
        }
        return image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categories=" + categories +
                ", image='" + image + '\'' +
                '}';
    }
}
