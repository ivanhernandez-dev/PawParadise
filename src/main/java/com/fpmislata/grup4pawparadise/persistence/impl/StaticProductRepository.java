package com.fpmislata.grup4pawparadise.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;

public class StaticProductRepository implements ProductRepository{

    List<Product> products = List.of();

    @Override
    public List<Product> getAll() {
        return this.products;
    }

    @Override
    public Product findById(int id) throws Exception{
        for (Product product : this.products) {
            if (product.getId() == id ) {
                return product;
            }  
        }
        throw new Exception("Producto no encontrado.");  
    }

    @Override
    public List<Product> findByCategoryId(int categoryId) {

        List<Product> products = new ArrayList<>();

        for (Product product : this.products) {
            if (product.getCategoryId() == categoryId ) {
                products.add(product);
            }  
        }
        return products; 
    }
    
}
