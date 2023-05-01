package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDBCProductRepository implements ProductRepository {

    private static final String SELECT_ALL_PRODUCTS = "SELECT p.*, pl.name_product, pl.description_text, pl.description_html " +
            "FROM product p JOIN product_language pl ON p.id_product = pl.id_product WHERE pl.language_type = ?";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT p.*, pl.name_product, pl.description_text, pl.description_html " +
            "FROM product p JOIN product_language pl ON p.id_product = pl.id_product WHERE p.id_product = ? AND pl.language_type = ?";
    private static final String SELECT_PRODUCTS_BY_CATEGORIES = "SELECT p.*, pl.name_product, pl.description_text, pl.description_html " +
            "FROM product p JOIN product_language pl ON p.id_product = pl.id_product WHERE id_category IN (%s) AND pl.language_type = ?";

    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found with id: ";
    private static final String SQL_EXCEPTION_MESSAGE = "SQL error occurred: ";

    @Override
    public List<Product> getAll(String language) {
        List<Object> params = List.of(language);
        return executeQuery(SELECT_ALL_PRODUCTS, params);
    }

    @Override
    public Product findById(int id, String language) throws ResourceNotFoundException {
        List<Object> params = List.of(id, language);
        List<Product> products = executeQuery(SELECT_PRODUCT_BY_ID, params);

        if (!products.isEmpty()) {
            return products.get(0);
        } else {
            throw new ResourceNotFoundException(PRODUCT_NOT_FOUND_MESSAGE + id);
        }
    }

    private Product createProductFromResultSet(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getInt("id_product"),
                resultSet.getString("name_product"),
                resultSet.getString("description_text"),
                resultSet.getString("description_html"),
                resultSet.getString("price"),
                resultSet.getInt("stock"),
                resultSet.getString("img_product"));
    }

    private List<Product> executeQuery(String query, List<Object> params) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = JDBCUtil.open();
             ResultSet resultSet = JDBCUtil.select(connection, query, params)) {
            while (resultSet.next()) {
                products.add(createProductFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(SQL_EXCEPTION_MESSAGE + e.getMessage(), e);
        }

        return products;
    }

    @Override
    public List<Product> findByCategoryIds(List<Integer> categoryIds, String language) {
        if (categoryIds == null || categoryIds.isEmpty()) {
            return new ArrayList<>();
        }

        String placeholders = String.join(",", Collections.nCopies(categoryIds.size(), "?"));
        String query = String.format(SELECT_PRODUCTS_BY_CATEGORIES, placeholders);

        List<Object> params = new ArrayList<>(categoryIds);
        params.add(language);

        return executeQuery(query, params);
    }
}
