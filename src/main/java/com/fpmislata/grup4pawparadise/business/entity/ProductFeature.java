package com.fpmislata.grup4pawparadise.business.entity;

public class ProductFeature {

    private int index;
    private String description;

    public ProductFeature(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ProductFeature{" +
                "index=" + index +
                ", description='" + description + '\'' +
                '}';
    }
}
