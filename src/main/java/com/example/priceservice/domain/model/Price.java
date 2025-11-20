package com.example.priceservice.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Price{
        Long brandId;
        Long productId;
        Integer priceList;
        Integer priority;
        BigDecimal amount;
        String currency;
        LocalDateTime startDate;
        LocalDateTime endDate;
}