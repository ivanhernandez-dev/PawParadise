package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Purchase;
import com.fpmislata.grup4pawparadise.business.service.PurchaseService;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.PurchaseRepository;
import com.fpmislata.grup4pawparadise.persistence.impl.JDBCPurchaseRepository;

public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository = new JDBCPurchaseRepository();

    @Override
    public Purchase getByUserIdWhereStatusActive(int idCustomer, String language) throws ResourceNotFoundException {
        return purchaseRepository.getByUserIdWhereStatusActive(idCustomer, language);
    }

    @Override
    public void updatePurchaseStatus(int idPurchase, int status, int idCustomer) {
        purchaseRepository.updatePurchaseStatus(idPurchase, idCustomer);
        purchaseRepository.insertWithStatusActive(idCustomer);
    }
}
