package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JDBCProductFeatureRepositoryImplTest {

    private static JDBCProductFeatureRepositoryImpl productFeatureRepository;

    @BeforeAll
    public static void setup() {
        productFeatureRepository = new JDBCProductFeatureRepositoryImpl();
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/product_feature_tables.sql")
                .addScript("db/sql/product_feature_data.sql")
                .build();
        productFeatureRepository.setDatasource(dataSource);
    }

    @DisplayName("Test getByProductIdAndLanguage(int, String)")
    @Test
    void getByProductIdAndLanguage() {
        List<ProductFeature> expectedProductFeatures = List.of(
                new ProductFeature(1, "Proporciona calidez y comodidad durante todo el día"),
                new ProductFeature(2, "Ideal para climas frescos"),
                new ProductFeature(3, "Fabricada con materiales de alta calidad"),
                new ProductFeature(4, "Diseño moderno y versátil"),
                new ProductFeature(5, "Capucha ajustable y bolsillos funcionales"),
                new ProductFeature(6, "Disponible en varios colores"),
                new ProductFeature(7, "Talla: unisex"),
                new ProductFeature(8, "Tejido transpirable que proporciona una buena ventilación")
        );

        List<ProductFeature> productFeatures = productFeatureRepository.getByProductIdAndLanguage(1, "es");

        assertEquals(expectedProductFeatures, productFeatures,
                "The product features retrieved should be the equal to the expected ones");
    }
}