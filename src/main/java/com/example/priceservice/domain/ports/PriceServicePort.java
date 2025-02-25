package com.example.priceservice.domain.ports;

import com.example.priceservice.application.dto.PriceResponse;

import java.time.LocalDateTime;

public interface PriceServicePort {
    PriceResponse getApplicablePrice(Long brandId, Long productId, LocalDateTime date);
}