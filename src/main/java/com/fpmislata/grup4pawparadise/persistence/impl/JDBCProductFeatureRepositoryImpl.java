package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.persistence.ProductFeatureRepository;
import com.fpmislata.grup4pawparadise.persistence.mapper.JDBCProductFeatureRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JDBCProductFeatureRepositoryImpl implements ProductFeatureRepository {

    private JdbcTemplate jdbcTemplate;

    public JDBCProductFeatureRepositoryImpl() {
        this.jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public void setDatasource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProductFeature> getByProductIdAndLanguage(int idProduct, String language) {
        final String SQL = "SELECT * FROM product_feature WHERE id_product = ? AND language_type = ? ORDER BY " +
                "index_product_feature ASC";

        return jdbcTemplate.query(
                SQL,
                new JDBCProductFeatureRowMapper(),
                idProduct,
                language);
    }
}
