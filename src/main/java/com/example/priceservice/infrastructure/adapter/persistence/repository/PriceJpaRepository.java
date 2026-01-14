package com.example.priceservice.infrastructure.adapter.persistence.repository;

import com.example.priceservice.infrastructure.adapter.persistence.entity.PriceEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE p.brandId = :brandId " +
            "AND p.productId = :productId " +
            "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<PriceEntity> findApplicablePrice(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applicationDate") LocalDateTime applicationDate,
            Pageable pageable);

    default Optional<PriceEntity> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return findApplicablePrice(brandId, productId, applicationDate, PageRequest.of(0, 1))
                .stream()
                .findFirst();
    }
}