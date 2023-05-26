package com.fpmislata.grup4pawparadise.persistence;

import com.fpmislata.grup4pawparadise.business.entity.Purchase;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

public interface PurchaseRepository {

    Purchase getByUserIdWhereStatusActive(int idCustomer, String language) throws ResourceNotFoundException;
    void insertWithStatusActive(int idCustomer);
    void updatePurchaseStatus(int idPurchase, int status);
}
