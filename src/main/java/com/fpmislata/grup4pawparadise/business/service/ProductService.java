package com.fpmislata.grup4pawparadise.business.service;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductService {
    
    public List<Product> getAll(String language);
    public Product findById(int id, String language) throws ResourceNotFoundException;
    public List<Product> findByCategoryIdWithSuccessors(int categoryId, String language) throws ResourceNotFoundException;
}
