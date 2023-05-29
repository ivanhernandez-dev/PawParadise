package com.fpmislata.grup4pawparadise.business.entity;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    private final int id;
    private String name;
    private String description;
    private List<ProductFeature> productFeatures;
    private BigDecimal price;
    private int stock;
    private String image;

    private final static String DEFAULT_IMAGE_URL = "/img/default.jpg";

    public Product(int id, String name, String description, List<ProductFeature> productFeatures, String price, int stock, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productFeatures = productFeatures;
        this.price = new BigDecimal(price);
        this.stock = stock;
        this.image = image;
    }

    public Product(int id, String name, String description, String price, int stock, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = new BigDecimal(price);
        this.stock = stock;
        this.image = image;
    }

    public void setProductFeatures(List<ProductFeature> productFeatures) {
        this.productFeatures = productFeatures;
    }

    public String getDescription() {
        return description;
    }

    public List<ProductFeature> getProductFeatures() {
        return productFeatures;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productFeatures='" + productFeatures + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", image='" + image + '\'' +
                '}';
    }
}
