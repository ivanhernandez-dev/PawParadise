package com.fpmislata.grup4pawparadise.business.service;

import com.fpmislata.grup4pawparadise.business.entity.Purchase;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

public interface PurchaseService {

    Purchase getByUserIdWhereStatusActive(int idCustomer, String language) throws ResourceNotFoundException;

    void updatePurchaseStatus(int idPurchase, int status, int idCustomer);
}
