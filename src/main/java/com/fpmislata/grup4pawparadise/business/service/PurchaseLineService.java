package com.fpmislata.grup4pawparadise.business.service;

public interface PurchaseLineService {

    void insert(int idPurchase, int idProduct, int quantity);
    void update(int idPurchase, int idProduct, int quantity);
    void delete(int idPurchase, int productId);
}
