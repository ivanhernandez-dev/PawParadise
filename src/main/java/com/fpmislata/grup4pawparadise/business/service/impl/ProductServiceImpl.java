package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.business.service.ProductService;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import com.fpmislata.grup4pawparadise.persistence.impl.JDBCCategoryRepository;
import com.fpmislata.grup4pawparadise.persistence.impl.JDBCProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository = new JDBCProductRepository();
    private CategoryRepository categoryRepository = new JDBCCategoryRepository();

    @Override
    public Product getById(int id, String language) throws ResourceNotFoundException {
        return this.productRepository.getById(id, language);
    }

    @Override
    public List<Product> getByCategoryIdWithSuccessors(int categoryId, String language) {
        List<Category> categories = this.categoryRepository.getSuccessorsByParentId(categoryId, language);

        List<Integer> categoryIds = new ArrayList<>();
        categoryIds.add(categoryId);
        for (Category category : categories) {
            categoryIds.add(category.getId());
        }

        return this.productRepository.getByCategoryIds(categoryIds, language);
    }
}
