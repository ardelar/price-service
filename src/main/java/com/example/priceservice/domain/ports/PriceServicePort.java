package com.example.priceservice.domain.ports;

import com.example.priceservice.application.dto.PriceResponse;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceServicePort {
    Optional<PriceResponse> findApplicablePrice(Long brandId, Long productId, LocalDateTime date);
}