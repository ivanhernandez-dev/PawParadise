package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.persistence.impl.JDBCPurchaseLineRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PurchaseLineServiceImplTest {

    @InjectMocks
    private PurchaseLineServiceImpl purchaseLineService;

    @Mock
    private JDBCPurchaseLineRepository jdbcPurchaseLineRepository;

    @DisplayName("Test insert(int, int, int) with invalid quantity when quantity is less than one")
    @Test
    void insertTestShouldThrowIllegalArgumentException_whenQuantityIsLessThanOne() {
        int idPurchase = 1;
        int idProduct = 1;
        int quantity = 0;

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> purchaseLineService.insert(idPurchase, idProduct, quantity),
                        "The method should throw an IllegalArgumentException."),
                () -> verify(jdbcPurchaseLineRepository, never()).insert(idPurchase, idProduct, quantity));
    }

    @DisplayName("Test insert(int, int, int) with invalid quantity when quantity is greater than fifteen")
    @Test
    void insertTestShouldThrowIllegalArgumentException_whenQuantityIsGreaterThanFifteen() {
        int idPurchase = 1;
        int idProduct = 1;
        int quantity = 16;

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> purchaseLineService.insert(idPurchase, idProduct, quantity),
                        "The method should throw an IllegalArgumentException."),
                () -> verify(jdbcPurchaseLineRepository, never()).insert(idPurchase, idProduct, quantity));
    }

    @DisplayName("Test insert(int, int, int) with valid quantity")
    @Test
    void insertTestShouldCallInsert_whenQuantityIsValid() {
        int idPurchase = 1;
        int idProduct = 1;
        int quantity = 1;

        purchaseLineService.insert(idPurchase, idProduct, quantity);

        verify(jdbcPurchaseLineRepository, description("The method insert should be called with parameters idPurchase="
                + idPurchase + "and idProduct=" + idProduct + "and quantity=" + quantity))
                .insert(idPurchase, idProduct, quantity);
    }

    @DisplayName("Test update(int, int, int) with invalid quantity when quantity is less than one")
    @Test
    void updateTestShouldThrowIllegalArgumentException_whenQuantityIsLessThanOne() {
        int idPurchase = 1;
        int idProduct = 1;
        int quantity = 0;

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> purchaseLineService.update(idPurchase, idProduct, quantity),
                        "The method should throw an IllegalArgumentException."),
                () -> verify(jdbcPurchaseLineRepository, never()).update(idPurchase, idProduct, quantity));
    }

    @DisplayName("Test update(int, int, int) with invalid quantity when quantity is greater than fifteen")
    @Test
    void updateTestShouldThrowIllegalArgumentException_whenQuantityIsGreaterThanFifteen() {
        int idPurchase = 1;
        int idProduct = 1;
        int quantity = 16;

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> purchaseLineService.update(idPurchase, idProduct, quantity),
                        "The method should throw an IllegalArgumentException."),
                () -> verify(jdbcPurchaseLineRepository, never()).update(idPurchase, idProduct, quantity));
    }

    @DisplayName("Test update(int, int, int) with valid quantity")
    @Test
    void updateTestShouldCallUpdate_whenQuantityIsValid() {
        int idPurchase = 1;
        int idProduct = 1;
        int quantity = 1;

        purchaseLineService.update(idPurchase, idProduct, quantity);

        verify(jdbcPurchaseLineRepository, description("The method update should be called with parameters idPurchase="
                + idPurchase + "and idProduct=" + idProduct + "and quantity=" + quantity))
                .update(idPurchase, idProduct, quantity);
    }

    @DisplayName("Test delete(int, int)")
    @Test
    void delete() {
        int idPurchase = 1;
        int idProduct = 1;

        purchaseLineService.delete(idPurchase, idProduct);

        verify(jdbcPurchaseLineRepository, description("The method delete should be called with parameters idPurchase="
                + idPurchase + "and idProduct=" + idProduct)).delete(idPurchase, idProduct);
    }
}