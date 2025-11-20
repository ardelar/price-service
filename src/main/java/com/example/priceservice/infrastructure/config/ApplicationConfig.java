package com.example.priceservice.infrastructure.config;

import com.example.priceservice.domain.ports.PriceServicePort;
import com.example.priceservice.domain.service.PriceService;
import com.example.priceservice.infrastructure.adapter.persistence.repository.PriceJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.priceservice.infrastructure")
public class ApplicationConfig {

    @Bean
    public PriceServicePort priceServicePort(PriceJpaRepository priceRepository) {
        return new PriceService(priceRepository);
    }
}