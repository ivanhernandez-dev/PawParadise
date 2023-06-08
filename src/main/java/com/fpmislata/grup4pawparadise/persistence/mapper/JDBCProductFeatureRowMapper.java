package com.fpmislata.grup4pawparadise.persistence.mapper;

import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCProductFeatureRowMapper implements RowMapper<ProductFeature> {

    @Override
    public ProductFeature mapRow(ResultSet rs, int rowNum) throws SQLException {
        int index = rs.getInt("index_product_feature");
        String description = rs.getString("description_feature");

        return new ProductFeature(index, description);
    }
}
