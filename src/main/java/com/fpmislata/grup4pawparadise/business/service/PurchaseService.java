package com.fpmislata.grup4pawparadise.business.service;

import com.fpmislata.grup4pawparadise.business.entity.Purchase;

public interface PurchaseService {
    Purchase getByUserIdWhereStatusActive(int userId);
    void insert(Purchase purchase);
    void update(Purchase purchase);
}
