package com.zara.mvp.dao;

import com.zara.mvp.domain.Price;
import com.zara.mvp.service.filter.PriceCriteria;

import java.util.List;

public interface PriceDAO {

    public List<Price> findByCriteria(PriceCriteria criteria);

}
