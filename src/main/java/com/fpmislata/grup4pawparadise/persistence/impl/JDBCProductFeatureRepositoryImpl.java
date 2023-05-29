package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.persistence.ProductFeatureRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductFeatureRepositoryImpl implements ProductFeatureRepository {

    private static final String SELECT_FEATURES_WHERE_ID_PRODUCT_AND_LANGUAGE = "SELECT * FROM product_feature WHERE " +
            "id_product = ? AND language_type = ? ORDER BY index_product_feature ASC";

    private static final String SQL_EXCEPTION_MESSAGE = "SQL error occurred: ";

    public List<ProductFeature> executeQuery(String query, List<Object> params) {
        List<ProductFeature> productFeatures = new ArrayList<>();
        Connection connection = JDBCUtil.open();
        ResultSet resultSet = JDBCUtil.select(connection, query, params);

        try {
            while (resultSet.next()) {
                productFeatures.add(createFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(SQL_EXCEPTION_MESSAGE + e.getMessage(), e);
        } finally {
            JDBCUtil.close(connection);
        }

        return productFeatures;
    }

    private ProductFeature createFromResultSet(ResultSet resultSet) throws SQLException {
        return new ProductFeature(resultSet.getInt("index_product_feature"),
                resultSet.getString("description_feature"));
    }

    @Override
    public List<ProductFeature> getByProductIdAndLanguage(int idProduct, String language) {
        List<Object> params = List.of(idProduct, language);
        return executeQuery(SELECT_FEATURES_WHERE_ID_PRODUCT_AND_LANGUAGE, params);
    }
}
