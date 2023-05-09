package com.fpmislata.grup4pawparadise.business.entity;

public class ShoppingCart {
    private final int id;
    private int quantity;
    private Product product;

    public ShoppingCart(int id, int quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }
}
