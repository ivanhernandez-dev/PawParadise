package com.fpmislata.grup4pawparadise.persistence.impl;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;

public class StaticProductRepository implements ProductRepository{

    List<Product>products = List.of(
        new Product(1, 1, "sudadera1", "23.90",10, "Sudadera para llevar el lomo calentito"),
        new Product(5, 2, "correa running1", "15.99", 3, "Correa flexible con cinturón"),
        new Product(9, 3, "Casco1", "50.99", 5, "Casco molón")
      );

    @Override
    public List<Product> getAll() {
        return this.products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : this.products) {
            if (product.getId() == id ) {
                return product;
            }  
        }
        return null;  
    }

    @Override
    public Product findByCategoryId(int categoryId) {
        for (Product product : this.products) {
            if (product.getCategoryId() == categoryId ) {
                return product;
            }  
        }
        return null; 
    }
    
}
