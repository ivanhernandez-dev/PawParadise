package com.fpmislata.grup4pawparadise.business.service.impl;

import com.fpmislata.grup4pawparadise.business.entity.Product;
import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;
import com.fpmislata.grup4pawparadise.business.entity.Purchase;
import com.fpmislata.grup4pawparadise.business.entity.PurchaseLine;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.PurchaseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceImplTest {

    @InjectMocks
    PurchaseServiceImpl purchaseService;

    @Mock
    PurchaseRepository purchaseRepository;

    @DisplayName("Test getByUserIdWhereStatusActive(int, String)")
    @Test
    void getByUserIdWhereStatusActive() throws ResourceNotFoundException {
        Purchase expectedPurchase = new Purchase(1, new Date(), 1, 1,
                List.of(
                        new PurchaseLine(1,
                                new Product(1, "Product 1", "Description 1",
                                        List.of(
                                                new ProductFeature(1, "One"),
                                                new ProductFeature(2, "Two")),
                                        "10.00", 30, "https://example.com/image.jpg"))));
        int idCustomer = 1;
        String language = "es";

        when(purchaseRepository.getByUserIdWhereStatusActive(idCustomer, language)).thenReturn(expectedPurchase);

        Purchase actualPurchase = purchaseService.getByUserIdWhereStatusActive(idCustomer, language);

        assertAll(
                () -> assertSame(expectedPurchase, actualPurchase,
                        "The purchase returned should be the same as the expected purchase"),
                () -> verify(purchaseRepository,
                        description("The method getByUserIdWhereStatusActive should be called " +
                                "with parameters idCustomer=" + idCustomer + " and language=" + language))
                        .getByUserIdWhereStatusActive(idCustomer, language));
    }

    @DisplayName("Test getByUserIdWhereStatusActive(int, String) when ResourceNotFoundException")
    @Test
    void getByUserIdWhereStatusActive_ResourceNotFoundException() throws ResourceNotFoundException {
        int idCustomer = -1;
        String language = "es";

        when(purchaseRepository.getByUserIdWhereStatusActive(idCustomer, language))
                .thenThrow(ResourceNotFoundException.class);

        assertAll(
                () -> assertThrows(ResourceNotFoundException.class,
                        () -> purchaseService.getByUserIdWhereStatusActive(idCustomer, language),
                        "The method getByUserIdWhereStatusActive should throw a ResourceNotFoundException"),
                () -> verify(purchaseRepository,
                        description("The method getByUserIdWhereStatusActive should be called " +
                                "with parameters idCustomer=" + idCustomer + " and language=" + language))
                        .getByUserIdWhereStatusActive(idCustomer, language));
    }

    @DisplayName("Test updatePurchaseStatus(int, int, int)")
    @Test
    void updatePurchaseStatus() {
        int idPurchase = 1;
        int status = 1;
        int idCustomer = 1;

        purchaseService.updatePurchaseStatus(idPurchase, status, idCustomer);

        assertAll(
                () -> verify(purchaseRepository, description("The method updatePurchaseStatus should be called " +
                        "with parameters idPurchase=" + idPurchase + ", status=" + status + " and idCustomer="
                        + idCustomer))
                        .updatePurchaseStatus(idPurchase, idCustomer),
                () -> verify(purchaseRepository, description("The method insertWithStatusActive should be called " +
                        "with parameters idCustomer=" + idCustomer))
                        .insertWithStatusActive(idCustomer));
    }
}