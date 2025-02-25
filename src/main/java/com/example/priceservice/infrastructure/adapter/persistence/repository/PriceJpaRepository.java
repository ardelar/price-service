package com.example.priceservice.infrastructure.adapter.persistence.repository;

import com.example.priceservice.infrastructure.adapter.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {
    @Query("SELECT p FROM PriceEntity p WHERE p.brandId = :brandId AND p.productId = :productId " +
           "AND p.startDate <= :date AND p.endDate >= :date")
    List<PriceEntity> findByBrandIdAndProductIdAndDate(Long brandId, Long productId, LocalDateTime date);
}