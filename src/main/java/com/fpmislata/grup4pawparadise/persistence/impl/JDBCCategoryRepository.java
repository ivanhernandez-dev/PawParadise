package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCategoryRepository implements CategoryRepository {

    private static final String SELECT_ALL_CATEGORIES_BY_LANGUAGE = "SELECT c.*, cl.name_category FROM category c JOIN " +
            "category_language cl ON c.id_category = cl.id_category WHERE cl.language_type = ? ORDER BY c.id_category";
    private static final String SELECT_CHILDREN_BY_PARENT_ID_AND_LANGUAGE = "SELECT c.*, cl.name_category FROM category c " +
            "JOIN category_language cl ON c.id_category = cl.id_category WHERE c.id_parent = ? AND cl.language_type = ? " +
            "ORDER BY c.id_category";
    private static final String SELECT_CHILDREN_WHERE_NULL_PARENT_BY_LANGUAGE = "SELECT c.*, cl.name_category FROM category c " +
            "JOIN category_language cl ON c.id_category = cl.id_category WHERE c.id_parent IS NULL AND cl.language_type = ? " +
            "ORDER BY c.id_category";

    private static final String SQL_EXCEPTION_MESSAGE = "SQL error occurred: ";

    @Override
    public List<Category> getAll(String language) {
        List<Object> params = List.of(language);
        List<Category> categories = new ArrayList<>();
        Map<Integer, Category> categoryMap = new HashMap<>();
        try (Connection connection = JDBCUtil.open();
            ResultSet resultSet = JDBCUtil.select(connection, SELECT_ALL_CATEGORIES_BY_LANGUAGE, params)) {
            while (resultSet.next()) {
                Category category = createCategoryFromResultSet(resultSet);
                categoryMap.put(category.getId(), category);
                if (resultSet.getObject("id_parent") == null) {
                    categories.add(category);
                }
            }
            resultSet.beforeFirst();
            while (resultSet.next()) {
                if (resultSet.getObject("id_parent") != null) {
                    Category category = categoryMap.get(resultSet.getInt("id_category"));
                    Category parentCategory = categoryMap.get(resultSet.getInt("id_parent"));
                    if (parentCategory.getCategories    () == null) {
                        parentCategory.setCategories(new ArrayList<>());
                    }
                    parentCategory.getCategories().add(category);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(SQL_EXCEPTION_MESSAGE + e.getMessage(), e);
        }
        return categories;
    }

    @Override
    public List<Category> getChildrenByParentId(Integer parentId, String language) {
        if (parentId == null) {
            List<Object> params = List.of(language);
            return executeQuery(SELECT_CHILDREN_WHERE_NULL_PARENT_BY_LANGUAGE, params);
        }
        List<Object> params = List.of(parentId, language);
        return executeQuery(SELECT_CHILDREN_BY_PARENT_ID_AND_LANGUAGE, params);
    }

    private List<Category> executeQuery(String query, List<Object> params) {
        List<Category> categories = new ArrayList<>();

        try (Connection connection = JDBCUtil.open();
             ResultSet resultSet = JDBCUtil.select(connection, query, params)) {

            while (resultSet.next()) {
                categories.add(createCategoryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(SQL_EXCEPTION_MESSAGE + e.getMessage(), e);
        }

        return categories;
    }

    private Category createCategoryFromResultSet(ResultSet resultSet) throws SQLException {
        return new Category(resultSet.getInt("id_category"), resultSet.getString("name_category"), resultSet.getString("img_category"));
    }

    @Override
    public List<Category> getSuccessorsByParentId(Integer parentId, String language) {
        List<Category> successors = new ArrayList<>();
        addSuccessorsRecursively(parentId, language, successors);
        return successors;
    }

    private void addSuccessorsRecursively(Integer parentId, String language, List<Category> successors) {
        List<Category> children = getChildrenByParentId(parentId, language);

        for (Category child : children) {
            successors.add(child);
            addSuccessorsRecursively(child.getId(), language, successors);
        }
    }
}
