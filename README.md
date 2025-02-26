# Price Service

## Overview
A Spring Boot application designed to retrieve applicable prices for products based on brand, product ID, and date. Built following a hexagonal architecture, adhering to SOLID principles and Clean Code practices.

## Technologies
- **Java 17**: Programming language.
- **Spring Boot 3.2.3**: Framework for building the application.
- **H2 Database**: In-memory database for data storage.
- **Lombok**: Reduces boilerplate code.
- **Maven**: Dependency management and build tool.
- **JaCoCo**: Code coverage tool.
- **JUnit 5**: Testing framework.

## Architecture
- **Hexagonal Architecture**: Domain (business logic), Application (DTOs), Infrastructure (adapters).
- **Patterns**: DDD (Value Object, Domain Service), SOLID.

## Setup
1. Clone the repository: `git clone https://github.com/tu-usuario/price-service.git`
2. Build and run: `mvn clean install && mvn spring-boot:run`
3. Access: `http://localhost:8080/api/prices`

## Usage
Example: `GET /api/prices?brandId=1&productId=35455&date=2020-06-14T10:00:00`


## Tests
Run: `mvn test`

Coverage: `mvn jacoco:report` (see `target/site/jacoco/index.html`)