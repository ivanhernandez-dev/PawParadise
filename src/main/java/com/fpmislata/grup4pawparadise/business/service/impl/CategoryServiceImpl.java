package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.business.service.CategoryService;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;
import com.fpmislata.grup4pawparadise.persistence.impl.JDBCCategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository = new JDBCCategoryRepository();

    @Override
    public List<Category> getAll(String language) {
        return this.categoryRepository.getAll(language);
    }

    @Override
    public List<Category> getChildrenByParentId(Integer parentId, String language) {
        return this.categoryRepository.getChildrenByParentId(parentId, language);
    }
}
