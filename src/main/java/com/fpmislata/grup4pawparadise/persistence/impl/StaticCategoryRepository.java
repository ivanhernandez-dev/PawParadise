package com.fpmislata.grup4pawparadise.persistence.impl;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;

public class StaticCategoryRepository implements CategoryRepository{

    List<Category> categories= List.of();

    @Override
    public List<Category> getAll() {
        return this.categories;
    }
    
}
