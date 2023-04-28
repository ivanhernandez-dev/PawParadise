package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Category;
import com.fpmislata.grup4pawparadise.persistence.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private static final String DEFAULT_IMAGE_URL = "https://example.com/default_image.jpg";
    private static final String CUSTOM_IMAGE_URL = "https://example.com/custom_image.jpg";

    private List<Category> expectedCategories;

    @BeforeEach
    public void setup() {
        expectedCategories = new ArrayList<>();

        Category subcategory1 = new Category(2, "Subcategory 1");
        Category subcategory2 = new Category(3, "Subcategory 2");
        List<Category> subcategories = new ArrayList<>();
        subcategories.add(subcategory1);
        subcategories.add(subcategory2);

        Category category1 = new Category(1, "Category 1", subcategories);
        Category category2 = new Category(4, "Category 2");

        expectedCategories.add(category1);
        expectedCategories.add(category2);
    }

    @DisplayName("Test get all categories")
    @Test
    public void testGetAll() {
        when(categoryRepository.getAll("en")).thenReturn(expectedCategories);

        List<Category> actual = categoryService.getAll("en");

        assertSame(expectedCategories, actual);
    }
}
