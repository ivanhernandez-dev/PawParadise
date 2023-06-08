package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.service.PurchaseLineService;
import com.fpmislata.grup4pawparadise.persistence.PurchaseLineRepository;
import com.fpmislata.grup4pawparadise.persistence.impl.JDBCPurchaseLineRepository;

public class PurchaseLineServiceImpl implements PurchaseLineService {

    private PurchaseLineRepository purchaseLineRepository = new JDBCPurchaseLineRepository();

    @Override
    public void insert(int idPurchase, int idProduct, int quantity) {
        checkQuantity(quantity);
        purchaseLineRepository.insert(idPurchase, idProduct, quantity);
    }

    @Override
    public void update(int idPurchase, int idProduct, int quantity) {
        checkQuantity(quantity);
        purchaseLineRepository.update(idPurchase, idProduct, quantity);
    }

    @Override
    public void delete(int idPurchase, int productId) {
        purchaseLineRepository.delete(idPurchase, productId);
    }

    private void checkQuantity(int quantity) {
        final int MAX_QUANTITY = 15;
        final int MIN_QUANTITY = 1;

        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("The quantity must be between " + MIN_QUANTITY + " and " + MAX_QUANTITY +
                    ".");
        }
    }
}
