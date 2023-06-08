package com.fpmislata.grup4pawparadise.business.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class PurchaseLine {

    private int quantity;
    private Product product;
    private BigDecimal totalPrice;

    public PurchaseLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "quantity=" + quantity +
                ", product=" + product +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseLine that = (PurchaseLine) o;
        return quantity == that.quantity && Objects.equals(product, that.product) && Objects.equals(totalPrice, that.totalPrice);
    }
}
