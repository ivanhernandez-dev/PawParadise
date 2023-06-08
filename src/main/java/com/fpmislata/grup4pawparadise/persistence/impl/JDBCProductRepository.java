package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.ProductFeatureRepository;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDBCProductRepository implements ProductRepository {

    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found with id: ";
    private static final String SQL_EXCEPTION_MESSAGE = "SQL error occurred: ";

    private final ProductFeatureRepository featureRepository = new JDBCProductFeatureRepositoryImpl();

    @Override
    public Product getById(int id, String language) throws ResourceNotFoundException {
        List<Object> params = List.of(id, language);
        final String SQL = "SELECT p.*, pl.name_product, pl.description_text FROM product p JOIN product_language pl " +
                "ON p.id_product = pl.id_product WHERE p.id_product = ? AND pl.language_type = ?";

        List<Product> products = executeQuery(SQL, params, language);

        if (!products.isEmpty()) {
            return products.get(0);
        } else {
            throw new ResourceNotFoundException(PRODUCT_NOT_FOUND_MESSAGE + id);
        }
    }

    private Product createProductFromResultSet(ResultSet resultSet, String language) throws SQLException {
        return new Product(resultSet.getInt("id_product"),
                resultSet.getString("name_product"),
                resultSet.getString("description_text"),
                featureRepository.getByProductIdAndLanguage(resultSet.getInt("id_product"), language),
                resultSet.getString("price"),
                resultSet.getInt("stock"),
                resultSet.getString("img_product"));
    }

    private List<Product> executeQuery(String query, List<Object> params, String language) {
        List<Product> products = new ArrayList<>();
        Connection connection = JDBCUtil.open();
        ResultSet resultSet = JDBCUtil.select(connection, query, params);
        try {
            while (resultSet.next()) {
                products.add(createProductFromResultSet(resultSet, language));
            }
        } catch (SQLException e) {
            throw new RuntimeException(SQL_EXCEPTION_MESSAGE + e.getMessage(), e);
        } finally {
            JDBCUtil.close(connection);
        }

        return products;
    }

    @Override
    public List<Product> getByCategoryIds(List<Integer> categoryIds, String language) {
        String sql = "SELECT p.*, pl.name_product, pl.description_text FROM product p JOIN product_language pl ON " +
                "p.id_product = pl.id_product WHERE id_category IN (%s) AND pl.language_type = ?";
        if (categoryIds == null || categoryIds.isEmpty()) {
            return new ArrayList<>();
        }

        String placeholders = String.join(",", Collections.nCopies(categoryIds.size(), "?"));
        sql = String.format(sql, placeholders);

        List<Object> params = new ArrayList<>(categoryIds);
        params.add(language);

        return executeQuery(sql, params, language);
    }

    @Override
    public List<Product> getByName(String name, String language) {
        final String SQL = "SELECT p.*, pl.name_product, pl.description_text FROM product p JOIN product_language pl " +
                "ON p.id_product = pl.id_product WHERE pl.name_product LIKE ? AND pl.language_type = ?";

        List<Object> params = List.of('%' + name + '%', language);
        return executeQuery(SQL, params, language);
    }
}
