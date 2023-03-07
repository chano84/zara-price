package com.zara.mvp.service.mapper;

import com.zara.mvp.controller.dto.PriceDTO;
import com.zara.mvp.domain.Price;

public class PricesMapper {

    public PriceDTO toDTO(Price price){
       return new PriceDTO(price.getBrandId(),
                price.getStartDate(), price.getEndDate(), price.getPriceList(),
                price.getProductId(), price.getPriority(), price.getPrice(),
                price.getCurr());
    }

}
