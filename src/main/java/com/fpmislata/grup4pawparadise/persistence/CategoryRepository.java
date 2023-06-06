package com.fpmislata.grup4pawparadise.persistence;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

import java.util.List;

public interface CategoryRepository {

    List<Category> getAll(String language);

    List<Category> getChildrenByParentId(Integer parentId, String language);

    List<Category> getSuccessorsByParentId(Integer parentId, String language);

    Category getById(int id, String language) throws ResourceNotFoundException;
}
