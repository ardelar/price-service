package com.example.priceservice.domain.service;

import com.example.priceservice.application.dto.PriceResponse;
import com.example.priceservice.domain.model.Price;
import com.example.priceservice.domain.ports.PriceRepositoryPort;
import com.example.priceservice.domain.ports.PriceServicePort;
//import com.example.priceservice.infrastructure.adapter.rest.exception.PriceNotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class PriceService implements PriceServicePort {

    private final PriceRepositoryPort priceRepository;

    public PriceService(PriceRepositoryPort priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse getApplicablePrice(Long brandId, Long productId, LocalDateTime date) {
        List<Price> prices = priceRepository.findApplicablePrices(brandId, productId, date);
        if (prices.isEmpty()) {
        	//TODO: Uncomment when PriceNotFoundException.java class is developed
//            throw new PriceNotFoundException("No price found for brand " + brandId + ", product " + productId + " at " + date);
        }

        Price applicablePrice = prices.stream()
                .max(Comparator.comparing(Price::priority))
                .orElseThrow(); // Should never happen due to prior check

        return new PriceResponse(
                applicablePrice.productId(),
                applicablePrice.brandId(),
                applicablePrice.priceList(),
                applicablePrice.startDate(),
                applicablePrice.endDate(),
                applicablePrice.amount()
        );
    }
}