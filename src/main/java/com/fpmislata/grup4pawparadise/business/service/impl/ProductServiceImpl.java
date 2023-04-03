package com.fpmislata.grup4pawparadise.business.service.impl;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.business.service.ProductService;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import com.fpmislata.grup4pawparadise.persistence.impl.StaticProductRepository;

public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository = new StaticProductRepository();

    @Override
    public List<Product> getAll() {
        return this.productRepository.getAll();
    }

    @Override
    public Product findById(int id) throws Exception {
        return this.productRepository.findById(id);
    }

    @Override
    public List<Product> findByCategoryId(int categoryId) {
        return this.productRepository.findByCategoryId(categoryId);
    }
    
    
}
