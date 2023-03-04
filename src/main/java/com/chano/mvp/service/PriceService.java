package com.chano.mvp.service;

import com.chano.mvp.dao.PriceDAO;
import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private final PriceDAO priceDAO;

    public PriceService(PriceDAO priceDAO) {
        this.priceDAO = priceDAO;
    }

    public List<Price> findByCriteria(PriceCriteria priceCriteria){
        return this.priceDAO.findByCriteria(priceCriteria);
    }

}
