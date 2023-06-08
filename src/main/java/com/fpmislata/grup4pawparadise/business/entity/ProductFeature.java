package com.fpmislata.grup4pawparadise.business.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProductFeature that = (ProductFeature) o;
        return index == that.index && Objects.equals(description, that.description);
    }
}
