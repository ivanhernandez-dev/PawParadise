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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private static final String CUSTOM_IMAGE_URL = "https://example.com/custom_image.jpg";

    private List<Category> expectedCategories;

    @BeforeEach
    public void setup() {
        expectedCategories = new ArrayList<>();

        Category subcategory1 = new Category(2, "Subcategory 1", CUSTOM_IMAGE_URL);
        Category subcategory2 = new Category(3, "Subcategory 2", CUSTOM_IMAGE_URL);
        List<Category> subcategories = new ArrayList<>();
        subcategories.add(subcategory1);
        subcategories.add(subcategory2);

        Category category1 = new Category(1, "Category 1", null);
        Category category2 = new Category(4, "Category 2", null);
        category1.setCategories(subcategories);

        expectedCategories.add(category1);
        expectedCategories.add(category2);
    }

    @DisplayName("Test getAll")
    @Test
    public void testGetAll() {
        String language = "en";

        when(categoryRepository.getAll(language)).thenReturn(expectedCategories);

        List<Category> actual = categoryService.getAll(language);

        assertAll(
                () -> assertSame(expectedCategories, actual, "The categories should be the same"),
                () -> verify(categoryRepository, description("The method getAll should be called with parameter language=" + language))
                        .getAll(language)
        );
    }

    @DisplayName("Test getChildrenByParentId(int, String)")
    @Test
    public void testGetChildrenByParentId() {
        String language = "en";
        int parentId = 1;

        when(categoryRepository.getChildrenByParentId(parentId, language)).thenReturn(expectedCategories.get(0).getCategories());

        List<Category> actual = categoryService.getChildrenByParentId(parentId, language);

        assertAll(
                () -> verify(categoryRepository, description("The method getChildrenByParentId should be called with " +
                        "parameters parentId=" + parentId + " and language=" + language))
                        .getChildrenByParentId(parentId, language),
                () -> assertSame(expectedCategories.get(0).getCategories(), actual, "The categories should be the same")
        );
    }
}
