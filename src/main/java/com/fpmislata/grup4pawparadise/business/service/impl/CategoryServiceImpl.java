package com.fpmislata.grup4pawparadise.business.service.impl;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;
import com.fpmislata.grup4pawparadise.persistence.impl.StaticCategoryRepository;

public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository repository = new StaticCategoryRepository();

    @Override
    public List<Category> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Category findById(int id) {
        return this.repository.findById(id);
    }
    
}
