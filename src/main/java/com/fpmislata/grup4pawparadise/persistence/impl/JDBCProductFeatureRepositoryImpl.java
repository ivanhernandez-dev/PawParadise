package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.persistence.ProductFeatureRepository;
import com.fpmislata.grup4pawparadise.persistence.mapper.JDBCProductFeatureRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductFeatureRepositoryImpl implements ProductFeatureRepository {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_FEATURES_WHERE_ID_PRODUCT_AND_LANGUAGE = "SELECT * FROM product_feature WHERE " +
            "id_product = ? AND language_type = ? ORDER BY index_product_feature ASC";

    public JDBCProductFeatureRepositoryImpl() {
        this.jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public void setDatasource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProductFeature> getByProductIdAndLanguage(int idProduct, String language) {
        return jdbcTemplate.query(
                SELECT_FEATURES_WHERE_ID_PRODUCT_AND_LANGUAGE,
                new JDBCProductFeatureRowMapper(),
                idProduct,
                language
        );
    }
}
