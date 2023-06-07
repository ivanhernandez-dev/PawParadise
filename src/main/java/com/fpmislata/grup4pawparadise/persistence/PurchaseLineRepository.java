package com.fpmislata.grup4pawparadise.persistence;

import com.fpmislata.grup4pawparadise.business.entity.PurchaseLine;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

import java.util.List;

public interface PurchaseLineRepository {

    void insert(int idPurchase, int idProduct, int quantity);

    void update(int idPurchase, int idProduct, int quantity);

    void delete(int idPurchase, int productId);

    List<PurchaseLine> getByPurchaseId(int idPurchase, String language);
}
