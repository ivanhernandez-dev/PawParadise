package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private List<Product> productList;
    private List<Product> expectedProducts;
    private List<Category> categories;

    @BeforeEach
    void setup() {
        this.productList = List.of(
                new Product(1, "Product 1", "Description 1", "<b>Description 1</b>", "10.00", 30, "https://example.com/image.jpg"),
                new Product(2, "Product 2", "Description 2", "<b>Description 2</b>", "20.00", 20, "https://example.com/image.jpg"),
                new Product(3, "Product 3", "Description 3", "<b>Description 3</b>", "30.00", 10, "https://example.com/image.jpg")
        );
        this.expectedProducts = List.of(new Product(1, "Comida para perros", "Comida de alta calidad para perros", "<b>Comida de alta calidad para perros</b>", "10", 100, "https://example.com/image.jpg"));
        this.categories = List.of(new Category(1, "Category 1", null), new Category(4, "Category 4", null));
    }

    @DisplayName("Test getAll(String)")
    @Test
    public void getAllTest() {
        String language = "es";
        when(productRepository.getAll(language)).thenReturn(productList);
        List<Product> actualProducts = productService.getAll(language);
        assertEquals(productList, actualProducts, "The lists should be equal");
    }

    @DisplayName("Test findById(int, String)")
    @Test
    public void findByIdTest() throws ResourceNotFoundException {
        int id = 1;
        String language = "es";
        when(productRepository.findById(id, language)).thenReturn(productList.get(0));
        Product actualProduct = productService.findById(id, language);
        assertEquals(productList.get(0), actualProduct, "The products should be equal");
    }

    @DisplayName("Test findByCategoryIdWithSuccessors(int)")
    @Test
    void findByCategoryIdWithSuccessorsTest() {
        int categoryId = 1;
        String language = "es";

        when(categoryRepository.getSuccessorsByParentId(categoryId, language)).thenReturn(categories);
        when(productRepository.findByCategoryIds(List.of(1, 1, 4), language)).thenReturn(expectedProducts);

        List<Product> actualProducts = productService.findByCategoryIdWithSuccessors(categoryId, language);
        assertEquals(expectedProducts, actualProducts, "The lists should be equal");
    }
}
