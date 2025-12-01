package com.example.priceservice.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class PriceResponse {
        Long productId;
        Long brandId;
        Integer priceList;
        LocalDateTime startDate;
        LocalDateTime endDate;
        BigDecimal price;
        Integer priority;

}