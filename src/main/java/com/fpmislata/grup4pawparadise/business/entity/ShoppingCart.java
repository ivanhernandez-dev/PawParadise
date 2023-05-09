package com.fpmislata.grup4pawparadise.business.entity;

public class ShoppingCart {
    private int quantity;
    private Product product;

    public ShoppingCart(int id, int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
