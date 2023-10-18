package com.resttemplate.service;

import com.resttemplate.dto.AvgPriceDto;
import com.resttemplate.dto.AvgPriceDtoConverter;
import com.resttemplate.model.AvgPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitcoinService {

    private final RestTemplate restTemplate;
    private final AvgPriceDtoConverter converter;
    private static final String URL_BTC_API = "https://api1.binance.com/api/v3/avgPrice?symbol=";

    public BitcoinService(RestTemplate restTemplate, AvgPriceDtoConverter converter) {
        this.restTemplate = restTemplate;
        this.converter = converter;
    }

    public AvgPriceDto getAvgPrice(String symbol) {

        AvgPrice avgPrice = restTemplate.getForObject(URL_BTC_API + symbol, AvgPrice.class);
        avgPrice.setSymbol(symbol);
        return converter.convert(avgPrice);
    }

}