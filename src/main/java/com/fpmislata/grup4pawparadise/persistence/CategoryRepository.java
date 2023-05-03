package com.fpmislata.grup4pawparadise.persistence;

import com.fpmislata.grup4pawparadise.business.entity.Category;

import java.util.List;

public interface CategoryRepository {
    
    List<Category> getAll(String language);
    List<Category> getChildrenByParentId(Integer parentId, String language);
    List<Category> getSuccessorsByParentId(Integer parentId, String language);
}
