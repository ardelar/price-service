package com.example.priceservice.infrastructure.adapter.persistence;

import com.example.priceservice.domain.model.Price;
import com.example.priceservice.domain.ports.PriceRepositoryPort;
import com.example.priceservice.infrastructure.adapter.persistence.entity.PriceEntity;
import com.example.priceservice.infrastructure.adapter.persistence.repository.PriceJpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJpaRepository priceJpaRepository;

    public PriceRepositoryAdapter(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }

    @Override
    public List<Price> findApplicablePrices(Long brandId, Long productId, LocalDateTime date) {
        return priceJpaRepository.findByBrandIdAndProductIdAndDate(brandId, productId, date)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Price toDomain(PriceEntity entity) {
        return new Price(
                entity.getBrandId(),
                entity.getProductId(),
                entity.getPriceList(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency(),
                entity.getStartDate(),
                entity.getEndDate()
        );
    }
}