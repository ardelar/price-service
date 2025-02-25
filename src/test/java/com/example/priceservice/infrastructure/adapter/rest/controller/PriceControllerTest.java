package com.example.priceservice.infrastructure.adapter.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.priceList").value(1));
    }

    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.priceList").value(2));
    }

    @Test
    void test3() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.priceList").value(1));
    }

    @Test
    void test4() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-15T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50))
                .andExpect(jsonPath("$.priceList").value(3));
    }

    @Test
    void test5() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.priceList").value(4));
    }
}