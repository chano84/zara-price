package com.chano.mvp.service;

import com.chano.mvp.dao.PriceDAO;
import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
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
