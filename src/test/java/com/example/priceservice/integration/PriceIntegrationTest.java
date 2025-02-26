package com.example.priceservice.integration;

import com.example.priceservice.application.dto.PriceResponse;
import com.example.priceservice.domain.ports.PriceServicePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PriceIntegrationTest {

    @Autowired
    private PriceServicePort priceService;

    @Test
    void testIntegration_getPriceAtSpecificDate() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");
        PriceResponse response = priceService.getApplicablePrice(1L, 35455L, date);

        assertNotNull(response);
        assertEquals(35455L, response.productId());
        assertEquals(1L, response.brandId());
        assertEquals(1, response.priceList());
        assertEquals(35.50, response.price().doubleValue());
    }
}