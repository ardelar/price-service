package com.example.priceservice.integration;

import com.example.priceservice.application.dto.PriceResponse;
import com.example.priceservice.domain.ports.PriceServicePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PriceIntegrationTest {

    @Autowired
    private PriceServicePort priceService;

    @Test
    void testIntegration_getPriceAtSpecificDate() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");
        Optional<PriceResponse> responseOptional = priceService.findApplicablePrice(1L, 35455L, date);

        assertTrue(responseOptional.isPresent(), "Should find a price for the given parameters");

        PriceResponse response = responseOptional.get();

        assertEquals(35455L, response.getProductId());
        assertEquals(1, response.getBrandId());
        assertEquals(1, response.getPriceList());
        assertEquals(35.50, response.getPrice().doubleValue());

        assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0, 0), response.getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), response.getEndDate());
    }
}