package com.example.priceservice.infrastructure.adapter.rest.controller;

import com.example.priceservice.application.dto.PriceResponse;
import com.example.priceservice.domain.ports.PriceServicePort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceServicePort priceService;

    public PriceController(PriceServicePort priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        PriceResponse response = priceService.getApplicablePrice(brandId, productId, date);
        return ResponseEntity.ok(response);
    }
}