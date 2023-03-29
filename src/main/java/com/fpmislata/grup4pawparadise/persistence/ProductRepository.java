package com.fpmislata.grup4pawparadise.persistence;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Product;

public interface ProductRepository {
    
    public List<Product> getAll();
    public Product findById(int id);
    public Product findByCategoryId(int categoryId);
}
