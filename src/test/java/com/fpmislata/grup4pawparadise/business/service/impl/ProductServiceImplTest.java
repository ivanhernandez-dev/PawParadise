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
                new Product(1, "Product 1", "10.00", 50, "Description 1"),
                new Product(2, "Product 2", "20.00", 20, "Description 2"),
                new Product(3, "Product 3", "30.00", 10, "Description 3")
        );
        this.expectedProducts = List.of(new Product(1, "Comida para perros", "10", 100, "Comida de alta calidad para perros"));
        this.categories = List.of(new Category(1, "Category 1"), new Category(4, "Category 4"));
    }
}
