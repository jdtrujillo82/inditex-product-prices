package com.example.productprices.service;

import com.example.productprices.exception.NotFoundException;
import com.example.productprices.model.Price;
import com.example.productprices.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InditexProductPricesServiceTest {
    @Mock
    private PriceRepository priceRepository;
    private InditexProductPricesService productPricesService;
    private Page<Price> pagedPrices;
    private Page<Price> emptyPagedPrices;

    @BeforeEach
    void init() {
        productPricesService = new InditexProductPricesService(priceRepository);
        List<Price> prices = Collections.singletonList(new Price());
        pagedPrices = new PageImpl<>(prices);
        emptyPagedPrices = new PageImpl<>(Collections.emptyList());
    }

    @Test
    void getSearchPriceOkTest() throws NotFoundException {
        when(priceRepository.getSearchPrice(any(Long.class), any(Long.class), any(OffsetDateTime.class), any(PageRequest.class)))
                .thenReturn(pagedPrices);
        Price result = productPricesService.getSearchPrice(1L, 1L, OffsetDateTime.now());
        assertNotNull(result);
    }

    @Test
    void getSearchPriceKOTest() {
        when(priceRepository.getSearchPrice(any(Long.class), any(Long.class), any(OffsetDateTime.class), any(PageRequest.class)))
                .thenReturn(emptyPagedPrices);
        NotFoundException exception = assertThrows(NotFoundException.class, () -> productPricesService.getSearchPrice(1L, 1L, OffsetDateTime.now()));
        String expectedMessage = "Unable to locate current price for brandId 1 productId 1 and applicationDate ";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

}
