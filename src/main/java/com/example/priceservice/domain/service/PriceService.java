package com.example.priceservice.domain.service;

import com.example.priceservice.application.dto.PriceResponse;
import com.example.priceservice.domain.ports.PriceServicePort;
import com.example.priceservice.infrastructure.adapter.persistence.entity.PriceEntity;
import com.example.priceservice.infrastructure.adapter.persistence.repository.PriceJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService implements PriceServicePort {

    private final PriceJpaRepository priceRepository;

    public PriceService(PriceJpaRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<PriceResponse> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceRepository.findApplicablePrice(brandId, productId, applicationDate)
                .map(this::convertToResponse);
    }

    private PriceResponse convertToResponse(PriceEntity priceEntity) {
        return PriceResponse.builder()
                .productId(priceEntity.getProductId())
                .brandId(priceEntity.getBrandId())
                .priceList(priceEntity.getPriceList())
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .price(priceEntity.getPrice())
                .priority(priceEntity.getPriority())
                .build();
    }

}