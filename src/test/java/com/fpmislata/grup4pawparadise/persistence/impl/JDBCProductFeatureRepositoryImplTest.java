package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JDBCProductFeatureRepositoryImplTest {

    private static JDBCProductFeatureRepositoryImpl productFeatureRepository;

    @BeforeAll
    public static void setup() {
        productFeatureRepository = new JDBCProductFeatureRepositoryImpl();
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .addScript("")
                .addScript("")
                .build();
        productFeatureRepository.setDatasource(dataSource);
    }

    @Test
    void getByProductIdAndLanguage() {
        List<ProductFeature> productFeatures = productFeatureRepository.getByProductIdAndLanguage(1, "ES");
    }
}