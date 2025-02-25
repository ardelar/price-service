package com.example.priceservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
        Long brandId,
        Long productId,
        Integer priceList,
        Integer priority,
        BigDecimal amount,
        String currency,
        LocalDateTime startDate,
        LocalDateTime endDate
) {}