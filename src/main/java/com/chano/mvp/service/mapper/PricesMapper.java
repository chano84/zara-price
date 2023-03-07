package com.chano.mvp.service.mapper;

import com.chano.mvp.controller.dto.PriceDTO;
import com.chano.mvp.domain.Price;

public class PricesMapper {

    public PriceDTO toDTO(Price price){
       return new PriceDTO(price.getBrandId(),
                price.getStartDate(), price.getEndDate(), price.getPriceList(),
                price.getProductId(), price.getPriority(), price.getPrice(),
                price.getCurr());
    }

}
