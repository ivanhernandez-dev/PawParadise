package com.fpmislata.grup4pawparadise.persistence;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Category;

public interface CategoryRepository {
    
    public List<Category> getAll();
    public Category findById(int id);
}
