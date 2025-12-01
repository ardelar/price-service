package com.example.priceservice.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices", indexes = {
        @Index(name = "idx_price_search",
                columnList = "BRAND_ID, PRODUCT_ID, START_DATE, END_DATE"),
        @Index(name = "idx_price_priority",
                columnList = "PRIORITY DESC")
})
@Data
@NoArgsConstructor
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}