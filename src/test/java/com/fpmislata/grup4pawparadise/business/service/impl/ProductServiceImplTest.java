package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private static List<ProductFeature> productFeatures;

    @BeforeAll
    public static void setUp() {
        productFeatures = List.of(new ProductFeature(1, "One"), new ProductFeature(2, "Two"));
    }

    @DisplayName("Test getById(int, String) with existing product")
    @Test
    public void getByIdTestShouldReturnProduct() throws ResourceNotFoundException {
        Product expectedProduct = new Product(1, "Product 1", "Description 1",
                productFeatures, "10.00", 30, "https://example.com/image.jpg");
        int id = 1;
        String language = "es";

        when(productRepository.getById(id, language)).thenReturn(expectedProduct);

        Product actualProduct = productService.getById(id, language);

        assertAll(
                () -> assertEquals(expectedProduct, actualProduct,
                        "The product returned should be equal to the expected product"),
                () -> verify(productRepository, description("The method getById should be called with parameters id=" +
                        id + " and language=" + language))
                        .getById(id, language)
        );
    }

    @DisplayName("Test getById(int, String) with non-existing product")
    @Test
    public void getByIdTestShouldThrowResourceNotFoundException() throws ResourceNotFoundException {
        int id = -1;
        String language = "es";

        when(productRepository.getById(-1, language)).thenThrow(ResourceNotFoundException.class);

        assertAll(
                () -> assertThrows(ResourceNotFoundException.class, () -> productService.getById(id, language),
                        "The method should throw a ResourceNotFoundException"),
                () -> verify(productRepository, description("The method getById should be called with parameters id=" +
                        id + " and language=" + language))
                        .getById(id, language)

        );
    }

    @DisplayName("Test getByCategoryIdWithSuccessors(int)")
    @Test
    void getByCategoryIdWithSuccessorsTest() {
        List<Product> expectedProducts = List.of(
                new Product(1, "Product 1", "Description 1", productFeatures,
                        "10.00", 30, "https://example.com/image.jpg"),
                new Product(2, "Product 2", "Description 2", productFeatures,
                        "20.00", 20, "https://example.com/image.jpg"),
                new Product(3, "Product 3", "Description 3", productFeatures,
                        "30.00", 10, "https://example.com/image.jpg")
        );
        List<Category> expectedCategories = List.of(new Category(2, "Category 2", null),
                new Category(3, "Category 3", null));


        int categoryId = 1;
        String language = "es";

        when(categoryRepository.getSuccessorsByParentId(categoryId, language)).thenReturn(expectedCategories);
        when(productRepository.getByCategoryIds(List.of(1, 2, 3), language)).thenReturn(expectedProducts);

        List<Product> actualProducts = productService.getByCategoryIdWithSuccessors(categoryId, language);

        assertAll(
                () -> verify(productRepository,
                        description("The method getByCategoryIds should be called with parameters=" + List.of(1, 2, 3) +
                                " and language=" + language))
                        .getByCategoryIds(List.of(1, 2, 3), language),
                () -> verify(categoryRepository,
                        description("The method getSuccessorsByParentId should be called with parameter 1 and language es"))
                        .getSuccessorsByParentId(categoryId, language),
                () -> assertEquals(expectedProducts, actualProducts, "The lists should be equal")
        );
    }

    @DisplayName("Test getByName(String, String) with null name")
    @Test
    void getByNameTestShouldThrowIllegalArgumentException() {
        String name = null;
        String language = "es";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> productService.getByName(name, language),
                        "The method should throw an IllegalArgumentException"),
                () -> verify(productRepository, never()).getByName(name, language)
        );
    }

    @DisplayName("Test getByName(String, String) with empty name")
    @Test
    void getByNameTestShouldThrowIllegalArgumentException2() {
        String name = "";
        String language = "es";

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> productService.getByName(name, language),
                        "The method should throw an IllegalArgumentException"),
                () -> verify(productRepository, never()).getByName(name, language)
        );
    }

    @DisplayName("Test getByName(String, String) with an existing name")
    @Test
    void getByNameTestShouldReturnProduct() throws ResourceNotFoundException {
        List<Product> expectedProducts = List.of(
                new Product(1, "Car 1", "Description 1", productFeatures,
                        "10.00", 30, "https://example.com/image.jpg"),
                new Product(2, "Car 2", "Description 2", productFeatures,
                        "20.00", 20, "https://example.com/image.jpg")
        );
        String name = "Car";
        String language = "es";

        when(productRepository.getByName(name, language)).thenReturn(expectedProducts);

        List<Product> actualProducts = productService.getByName(name, language);

        assertAll(
                () -> verify(productRepository,
                        description("The method getByName should be called with parameters name=" + name +
                                " and language=" + language))
                        .getByName(name, language),
                () -> assertEquals(expectedProducts, actualProducts, "The lists should be equal")
        );
    }

    @DisplayName("Test getByName(String, String) with a non-existing name")
    @Test
    void getByNameTestShouldThrowResourceNotFoundException() {
        String name = "Car";
        String language = "es";
        List<Product> expectedProducts = List.of();

        when(productRepository.getByName(name, language)).thenReturn(expectedProducts);

        assertAll(
                () -> assertThrows(ResourceNotFoundException.class, () -> productService.getByName(name, language),
                        "The method should throw a ResourceNotFoundException"),
                () -> verify(productRepository,
                        description("The method getByName should be called with parameters name=" + name +
                                " and language=" + language))
                        .getByName(name, language)
        );
    }
}
