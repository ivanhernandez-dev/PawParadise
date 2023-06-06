package com.fpmislata.grup4pawparadise.business.service;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    List<Category> getAll(String language);

    List<Category> getChildrenByParentId(Integer parentId, String language);

    Category getById(Integer id, String language) throws ResourceNotFoundException;
}
