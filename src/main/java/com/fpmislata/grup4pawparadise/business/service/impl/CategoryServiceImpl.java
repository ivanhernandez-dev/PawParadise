package com.fpmislata.grup4pawparadise.business.service.impl;

import java.util.List;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;

public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository = new StaticCategoryRepository();

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.getAll();
    }

    
}
