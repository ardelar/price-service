package com.example.priceservice.integration;

import com.example.priceservice.application.dto.PriceResponse;
import com.example.priceservice.domain.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PriceIntegrationTest {

    @Autowired
    private PriceService priceService;

    @Test
    void testIntegration_getPriceAtSpecificDate() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");
        Optional<PriceResponse> responseOptional = priceService.findApplicablePrice(1L, 35455L, date);

        assertTrue(responseOptional.isPresent(), "Test should find a price for the given parameters");

        PriceResponse response = responseOptional.get();

        assertEquals(35455L, response.productId());
        assertEquals(1, response.brandId());
        assertEquals(1, response.priceList());
        assertEquals(35.50, response.price().doubleValue());
    }

    @Test
    void testIntegration_exactStartDate() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T15:00:00");
        Optional<PriceResponse> response = priceService.findApplicablePrice(1L, 35455L, date);
        assertTrue(response.isPresent());
        assertEquals(2, response.get().priceList());
    }

    @Test
    void testIntegration_priorityResolution() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T16:00:00");
        Optional<PriceResponse> response = priceService.findApplicablePrice(1L, 35455L, date);
        assertTrue(response.isPresent());
    }

    @Test
    void testIntegration_noPriceFound() {
        LocalDateTime date = LocalDateTime.parse("2020-01-01T00:00:00");
        Optional<PriceResponse> response = priceService.findApplicablePrice(1L, 35455L, date);
        assertFalse(response.isPresent());
    }
}