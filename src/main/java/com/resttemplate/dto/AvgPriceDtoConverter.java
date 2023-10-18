package com.resttemplate.dto;

import com.resttemplate.model.AvgPrice;
import org.springframework.stereotype.Component;

@Component
public class AvgPriceDtoConverter {

    public AvgPriceDto convert(AvgPrice avgPrice) {
        AvgPriceDto avgPriceDto = AvgPriceDto.builder()
                .mins(avgPrice.getMins())
                .price(avgPrice.getPrice())
                .symbol(avgPrice.getSymbol())
                .build();

        return avgPriceDto;
    }
}