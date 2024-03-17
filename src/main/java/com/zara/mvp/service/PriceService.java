package com.zara.mvp.service;

import com.zara.mvp.domain.Price;
import com.zara.mvp.service.filter.PriceCriteria;

import java.util.List;

public interface PriceService {

    public List<Price> findByCriteria(PriceCriteria priceCriteria);

}