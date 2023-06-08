package com.fpmislata.grup4pawparadise.business.entity;

import java.math.BigDecimal;

public class PurchaseLine {

    private int id;
    private int quantity;
    private Product product;
    private BigDecimal totalPrice;

    public PurchaseLine(int id, int quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public int getId() {
        return id;
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
                '}';
    }
}
