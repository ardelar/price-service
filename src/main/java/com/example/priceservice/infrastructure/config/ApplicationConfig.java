package com.example.priceservice.infrastructure.config;

import com.example.priceservice.domain.ports.PriceRepositoryPort;
import com.example.priceservice.domain.ports.PriceServicePort;
import com.example.priceservice.domain.service.PriceService;
import com.example.priceservice.infrastructure.adapter.persistence.PriceRepositoryAdapter;
import com.example.priceservice.infrastructure.adapter.persistence.repository.PriceJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.priceservice.infrastructure")
public class ApplicationConfig {

    @Bean
    public PriceRepositoryPort priceRepositoryPort(PriceJpaRepository priceJpaRepository) {
        return new PriceRepositoryAdapter(priceJpaRepository);
    }

    @Bean
    public PriceServicePort priceServicePort(PriceRepositoryPort priceRepositoryPort) {
        return new PriceService(priceRepositoryPort);
    }
}