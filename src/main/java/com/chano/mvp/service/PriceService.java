package com.chano.mvp.service;

import com.chano.mvp.dao.PriceDAO;
import com.chano.mvp.domain.Price;
import com.chano.mvp.service.filter.PriceCriteria;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private final PriceDAO priceDAO;

    private static final Logger logger = Logger.getLogger(PriceService.class);

    public PriceService(PriceDAO priceDAO) {
        this.priceDAO = priceDAO;
    }

    public List<Price> findByCriteria(PriceCriteria priceCriteria){
        logger.info("PriceService.findByCriteria criteria: ".concat(priceCriteria.toString()));
        return this.priceDAO.findByCriteria(priceCriteria);
    }

}
