package com.fpmislata.grup4pawparadise.persistence;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductRepository {

    Product getById(int id, String language) throws ResourceNotFoundException;
    List<Product> getByCategoryIds(List<Integer> categoryIds, String language);
}
