package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.business.entity.PurchaseLine;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JDBCPurchaseLineRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private static JDBCPurchaseLineRepository jdbcPurchaseLineRepository;

    private static DataSource dataSource;

    @BeforeAll
    public static void setup() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/purchase_line_tables.sql")
                .build();
        jdbcPurchaseLineRepository = new JDBCPurchaseLineRepository();
        jdbcPurchaseLineRepository.setDatasource(dataSource);
    }

    @AfterEach
    public void teardown() throws SQLException {
        DataSource dataSource = jdbcPurchaseLineRepository.getDatasource();

        ClassPathResource resource = new ClassPathResource("db/sql/purchase_line_insert_data.sql");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
    }

    @BeforeEach
    public void insertData() throws SQLException {
        DataSource dataSource = jdbcPurchaseLineRepository.getDatasource();

        ClassPathResource resource = new ClassPathResource("db/sql/purchase_line_delete_data.sql");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
    }

    @DisplayName("Test getByPurchaseId(int, String) when purchase has purchase lines")
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

        assertAll(
                () -> verify(productRepository, description("")).getById(1, "es"),
                () -> verify(productRepository).getById(2, "es"),
                () -> assertEquals(expectedPurchaseLines, actualPurchaseLines,
                        "The purchase lines returned should be the same as the expected purchase lines")
        );
    }

    @DisplayName("Test getByPurchaseId(int, String) when purchase has no purchase lines")
    @Test
    void testGetByPurchaseId_purchaseHasNoPurchaseLines() throws ResourceNotFoundException {
        int idPurchase = -1;
        String language = "es";

        List<PurchaseLine> actualPurchaseLines = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        assertAll(
                () -> verify(productRepository, never()).getById(anyInt(), anyString()),
                () -> assertTrue(actualPurchaseLines.isEmpty(),
                        "The purchase lines returned should be empty")
        );
    }

    @DisplayName("Test insert(int, int, int)")
    @Test
    void testInsert() throws ResourceNotFoundException {
        int idPurchase = 1;
        String language = "es";

        Product product1 = new Product(1, "Product 1", "Description 1", null,
                "10.00", 30, "https://example.com/image.jpg");
        Product product2 = new Product(2, "Product 2", "Description 2", null,
                "20.00", 20, "https://example.com/image.jpg");
        List<PurchaseLine> expectedPurchaseLines = new ArrayList<>();
        expectedPurchaseLines.add(new PurchaseLine(1, product1));
        expectedPurchaseLines.add(new PurchaseLine(2, product2));

        when(productRepository.getById(1, "es")).thenReturn(product1);
        when(productRepository.getById(2, "es")).thenReturn(product2);

        List<PurchaseLine> purchaseLinesBeforeInsert = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        assertAll(
                () -> verify(productRepository).getById(1, "es"),
                () -> verify(productRepository).getById(2, "es"),
                () -> assertEquals(expectedPurchaseLines, purchaseLinesBeforeInsert,
                        "The purchase lines returned should be the same as the expected purchase lines")
        );

        Product product3 = new Product(3, "Product 3", "Description 3", null,
                "30.00", 10, "https://example.com/image.jpg");
        expectedPurchaseLines.add(new PurchaseLine(3, product3));

        jdbcPurchaseLineRepository.insert(3, 3, 1);

        when(productRepository.getById(3, "es")).thenReturn(product3);

        List<PurchaseLine> purchaseLinesAfterInsert = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        assertAll(
                () -> verify(productRepository).getById(1, "es"),
                () -> verify(productRepository).getById(2, "es"),
                () -> verify(productRepository).getById(3, "es"),
                () -> assertEquals(expectedPurchaseLines, purchaseLinesAfterInsert,
                        "The purchase lines returned should be the same as the expected purchase lines")
        );
    }

    @DisplayName("Test delete(int, int)")
    @Test
    void testDelete() throws ResourceNotFoundException {
        int idPurchase = 1;
        String language = "es";

        Product product1 = new Product(1, "Product 1", "Description 1", null,
                "10.00", 30, "https://example.com/image.jpg");
        Product product2 = new Product(2, "Product 2", "Description 2", null,
                "20.00", 20, "https://example.com/image.jpg");
        List<PurchaseLine> expectedPurchaseLines = new ArrayList<>();
        expectedPurchaseLines.add(new PurchaseLine(1, product1));
        expectedPurchaseLines.add(new PurchaseLine(2, product2));

        when(productRepository.getById(1, "es")).thenReturn(product1);
        when(productRepository.getById(2, "es")).thenReturn(product2);

        List<PurchaseLine> purchaseLinesBeforeDelete = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        assertAll(
                () -> verify(productRepository).getById(1, "es"),
                () -> verify(productRepository).getById(2, "es"),
                () -> assertEquals(expectedPurchaseLines, purchaseLinesBeforeDelete,
                        "The purchase lines returned should be the same as the expected purchase lines")
        );

        expectedPurchaseLines.remove(0);

        jdbcPurchaseLineRepository.delete(1, 1);

        List<PurchaseLine> purchaseLinesAfterDelete = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        assertAll(
                () -> verify(productRepository).getById(1, "es"),
                () -> verify(productRepository).getById(2, "es"),
                () -> assertEquals(expectedPurchaseLines, purchaseLinesAfterDelete,
                        "The purchase lines returned should be the same as the expected purchase lines")
        );
    }

    @DisplayName("Test update(int, int, int)")
    @Test
    void testUpdate() throws ResourceNotFoundException {
        int idPurchase = 1;
        String language = "es";

        Product product1 = new Product(1, "Product 1", "Description 1", null,
                "10.00", 30, "https://example.com/image.jpg");
        Product product2 = new Product(2, "Product 2", "Description 2", null,
                "20.00", 20, "https://example.com/image.jpg");
        List<PurchaseLine> expectedPurchaseLines = new ArrayList<>();
        expectedPurchaseLines.add(new PurchaseLine(1, product1));
        expectedPurchaseLines.add(new PurchaseLine(2, product2));

        when(productRepository.getById(1, "es")).thenReturn(product1);
        when(productRepository.getById(2, "es")).thenReturn(product2);

        List<PurchaseLine> purchaseLinesBeforeUpdate = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        assertAll(
                () -> verify(productRepository).getById(1, "es"),
                () -> verify(productRepository).getById(2, "es"),
                () -> assertEquals(expectedPurchaseLines, purchaseLinesBeforeUpdate,
                        "The purchase lines returned should be the same as the expected purchase lines")
        );

        expectedPurchaseLines.set(0, new PurchaseLine(2, product1));

        jdbcPurchaseLineRepository.update(1, 1, 2);

        List<PurchaseLine> purchaseLinesAfterUpdate = jdbcPurchaseLineRepository.getByPurchaseId(idPurchase, language);

        assertAll(
                () -> verify(productRepository).getById(1, "es"),
                () -> verify(productRepository).getById(2, "es"),
                () -> assertEquals(expectedPurchaseLines, purchaseLinesAfterUpdate,
                        "The purchase lines returned should be the same as the expected purchase lines")
        );
    }
}