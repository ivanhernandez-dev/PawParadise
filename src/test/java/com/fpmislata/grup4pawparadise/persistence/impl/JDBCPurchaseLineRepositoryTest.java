package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.business.entity.PurchaseLine;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JDBCPurchaseLineRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private static JDBCPurchaseLineRepository jdbcPurchaseLineRepository;

    @BeforeAll
    public static void setup() {
        jdbcPurchaseLineRepository = new JDBCPurchaseLineRepository();
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/purchase_line_tables.sql")
                .addScript("db/sql/purchase_line_data.sql")
                .build();
        jdbcPurchaseLineRepository.setDatasource(dataSource);
    }

    @DisplayName("Test getByPurchaseId(int, String) when purchase has no purchase lines")
    @Test
    void testGetByPurchaseId_purchaseHasPurchaseLines() throws ResourceNotFoundException {
        int idPurchase = 1;
        String language = "es";

        Product product1 = new Product(1, "Product 1", "Description 1", null,
                "10.00", 30, "https://example.com/image.jpg");
        Product product2 = new Product(2, "Product 2", "Description 2", null,
                "20.00", 20, "https://example.com/image.jpg");
        List<PurchaseLine> expectedPurchaseLines = List.of(
                new PurchaseLine(2, product1),
                new PurchaseLine(1, product2)
        );

        when(productRepository.getById(1, "es")).thenReturn(product1);
        when(productRepository.getById(2, "es")).thenReturn(product2);

        List<PurchaseLine> actualPurchaseLines = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        verify(productRepository, description("")).getById(1, "es");
        verify(productRepository).getById(2, "es");
        assertEquals(expectedPurchaseLines, actualPurchaseLines,
                "The purchase lines returned should be the same as the expected purchase lines");
    }

    @DisplayName("Test getByPurchaseId(int, String) when purchase has no purchase lines")
    @Test
    void testGetByPurchaseId_purchaseHasNoPurchaseLines() throws ResourceNotFoundException {
        int idPurchase = -1;
        String language = "es";

        List<PurchaseLine> actualPurchaseLines = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        verify(productRepository, never()).getById(anyInt(), anyString());
        assertTrue(actualPurchaseLines.isEmpty(),
                "The purchase lines returned should be empty");
    }
}