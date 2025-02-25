package com.example.priceservice.domain.ports;

import com.example.priceservice.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {
    List<Price> findApplicablePrices(Long brandId, Long productId, LocalDateTime date);
}