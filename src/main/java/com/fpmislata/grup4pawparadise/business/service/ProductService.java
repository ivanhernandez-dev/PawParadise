package com.fpmislata.grup4pawparadise.business.service;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductService {

    Product getById(int id, String language) throws ResourceNotFoundException;
    List<Product> getByCategoryIdWithSuccessors(int categoryId, String language);
    List<Product> getByName(String name, String language) throws ResourceNotFoundException;
}
