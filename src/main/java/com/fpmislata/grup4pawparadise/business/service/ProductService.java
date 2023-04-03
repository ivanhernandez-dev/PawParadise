package com.fpmislata.grup4pawparadise.business.service;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Product;

public interface ProductService {
    
    public List<Product> getAll();
    public Product findById(int id) throws Exception;
    public List<Product> findByCategoryId(int categoryId);
}
