package com.fpmislata.grup4pawparadise.business.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductTest {

    private Product product;
    private final static String DEFAULT_IMAGE_URL = "https://example.com/default_image.jpg";
    private final static String CUSTOM_IMAGE_URL = "https://example.com/image.jpg";

    @DisplayName("Test constructors")
    @Nested
    class TestConstructors {
        @DisplayName("Test constructor with id, name, price, stock, description, HTML description and image")
        @Test
        public void testConstructorWithIdNamePriceStockDescriptionHTMLImage() {
            product = new Product(1, "Product 1", "Product description", "<b>Product description</b>", "10.50", 5, CUSTOM_IMAGE_URL);

            assertEquals(1, product.getId(), "Product id should be 1");
            assertEquals("Product 1", product.getName(), "Product name should be 'Product 1'");
            assertEquals("Product description", product.getDescription(), "Product description should be 'Product description'");
            assertEquals("<b>Product description</b>", product.getDescriptionHTML(), "Product HTML description should be '<b>Product description</b>'");
            assertEquals(new BigDecimal("10.50"), product.getPrice(), "Product price should be 10.50");
            assertEquals(5, product.getStock(), "Product stock should be 5");
            assertEquals(CUSTOM_IMAGE_URL, product.getImage(), "Product image should be the custom image");
        }
    }

    @DisplayName("Test getters")
    @Nested
    class TestGetters {
        @BeforeEach
        public void setUp() {
            product = new Product(1, "Product 1", "Product description", "<b>Product description</b>", "10.50", 0, null);
        }

        @DisplayName("Test getId")
        @Test
        public void testGetId() {
            assertEquals(1, product.getId(), "Product id should be 1");
        }

        @DisplayName("Test getName")
        @Test
        public void testGetName() {
            assertEquals("Product 1", product.getName(), "Product name should be 'Product 1'");
        }

        @DisplayName("Test getDescription")
        @Test
        public void testGetDescription() {
            assertEquals("Product description", product.getDescription(), "Product description should be 'Product description'");
        }

        @DisplayName("Test getDescriptionHTML")
        @Test
        public void testGetDescriptionHTML() {
            assertEquals("<b>Product description</b>", product.getDescriptionHTML(), "Product HTML description should be '<b>Product description</b>'");
        }

        @DisplayName("Test getPrice")
        @Test
        public void testGetPrice() {
            assertEquals(new BigDecimal("10.50"), product.getPrice(), "Product price should be 10.50");
        }

        @DisplayName("Test getStock")
        @Test
        public void testGetStock() {
            assertEquals(0, product.getStock(), "Product stock should be 0");
        }

        @DisplayName("Test getImage with default image")
        @Test
        public void testGetImageWithDefaultImage() {
            assertEquals(DEFAULT_IMAGE_URL, product.getImage(), "Product image should be the default image");
        }

        @DisplayName("Test getImage with custom image")
        @Test
        public void testGetImageWithCustomImage() {
            product = new Product(1, "Product 1", "Product description", "<b>Product description</b>", "10.50", 5, CUSTOM_IMAGE_URL);
            assertEquals(CUSTOM_IMAGE_URL, product.getImage(), "Product image should be the custom image");
        }
    }

    @DisplayName("Test toString")
    @Test
    public void testToString() {
        product = new Product(1, "Product 1", "Product description", "<b>Product description</b>", "10.50", 0, CUSTOM_IMAGE_URL);
        String expected = "Product{id=1, name='Product 1', description='Product description', descriptionHTML='<b>Product description</b>', price=10.50, stock=0, image='" + CUSTOM_IMAGE_URL + "'}";
        assertEquals(expected, product.toString(), "Product toString should return the correct string");
    }
}
