package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @DisplayName("Test getById(int, String)")
    @Test
    public void getByIdTest() throws ResourceNotFoundException {
        Product expectedProduct = new Product(1, "Product 1", "Description 1",
                "<b>Description 1</b>", "10.00", 30, "https://example.com/image.jpg");
        int id = 1;
        String language = "es";

        when(productRepository.getById(id, language)).thenReturn(expectedProduct);

        Product actualProduct = productService.getById(id, language);

        assertEquals(expectedProduct, actualProduct, "The products should be equal");
    }

    @DisplayName("Test getByCategoryIdWithSuccessors(int)")
    @Test
    void getByCategoryIdWithSuccessorsTest() {
        List<Product> expectedProducts = List.of(
                new Product(1, "Product 1", "Description 1", "<b>Description 1</b>",
                        "10.00", 30, "https://example.com/image.jpg"),
                new Product(2, "Product 2", "Description 2", "<b>Description 2</b>",
                        "20.00", 20, "https://example.com/image.jpg"),
                new Product(3, "Product 3", "Description 3", "<b>Description 3</b>",
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
                        description("The method getByCategoryIds should be called with parameters 1, 2, 3"))
                        .getByCategoryIds(List.of(1, 2, 3), language),
                () -> assertEquals(expectedProducts, actualProducts, "The lists should be equal")
        );
    }
}
