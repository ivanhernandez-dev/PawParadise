package com.fpmislata.grup4pawparadise.business.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CategoryTest {

    private Category category;
    private final static String DEFAULT_IMAGE_URL = "https://example.com/default_image.jpg";
    private final static String CUSTOM_IMAGE_URL = "https://example.com/image.jpg";

    @DisplayName("Test constructors")
    @Nested
    class TestConstructors {
        @DisplayName("Test constructor with id, name and image")
        @Test
        public void testConstructorWithIdNameAndImage() {
            category = new Category(1, "Category 1", CUSTOM_IMAGE_URL);
            assertEquals(1, category.getId(), "Category id should be 1");
            assertEquals("Category 1", category.getName(), "Category name should be 'Category 1'");
            assertNull(category.getCategories(), "Category subcategories should be null");
            assertEquals(CUSTOM_IMAGE_URL, category.getImage(), "Category image should be the custom image");
        }
    }

    @DisplayName("Test getters and setters")
    @Nested
    class TestGettersAndSetters {
        @BeforeEach
        public void setUp() {
            category = new Category(1, "Category 1", null);
        }

        @DisplayName("Test getId")
        @Test
        public void testGetId() {
            assertEquals(1, category.getId(), "Category id should be 1");
        }

        @DisplayName("Test getName")
        @Test
        public void testGetName() {
            assertEquals("Category 1", category.getName(), "Category name should be 'Category 1'");
        }

        @DisplayName("Test getCategories without subcategories")
        @Test
        public void testGetCategoriesWithoutSubcategories() {
            assertNull(category.getCategories(), "Category subcategories should be null");
        }

        @DisplayName("Test getCategories with subcategories")
        @Test
        public void testGetCategoriesWithSubcategories() {
            List<Category> subcategories = new ArrayList<>();
            subcategories.add(new Category(2, "Subcategory 1", null));
            subcategories.add(new Category(3, "Subcategory 2", null));
            category.setCategories(subcategories);

            assertEquals(subcategories, category.getCategories(), "Category subcategories should be the same");
        }

        @DisplayName("Test getImage with default image")
        @Test
        public void testGetImageWithDefaultImage() {
            assertEquals(DEFAULT_IMAGE_URL, category.getImage(), "Category image should be the default image");
        }

        @DisplayName("Test getImage with custom image")
        @Test
        public void testGetImageWithCustomImage() {
            category = new Category(1, "Category 1", CUSTOM_IMAGE_URL);
            assertEquals(CUSTOM_IMAGE_URL, category.getImage(), "Category image should be the custom image");
        }

        @DisplayName("Test setCategories")
        @Test
        public void testSetCategories() {
            List<Category> subcategories = new ArrayList<>();
            subcategories.add(new Category(2, "Subcategory 1", null));
            subcategories.add(new Category(3, "Subcategory 2", null));
            category.setCategories(subcategories);

            assertEquals(subcategories, category.getCategories(), "Category subcategories should be the same");
        }
    }

    @DisplayName("Test toString")
    @Test
    public void testToString() {
        category = new Category(1, "Category 1", null);
        assertEquals("Category{id=1, name='Category 1', categories=null, image='null'}", category.toString(), "Category toString should be 'Category{id=1, name='Category 1', categories=null, image='null'}'");
    }
}
