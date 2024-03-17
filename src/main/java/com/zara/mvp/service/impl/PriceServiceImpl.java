package com.zara.mvp.service.impl;

import com.zara.mvp.dao.PriceDAO;
import com.zara.mvp.dao.impl.PriceDAOImpl;
import com.zara.mvp.domain.Price;
import com.zara.mvp.service.PriceService;
import com.zara.mvp.service.filter.PriceCriteria;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceDAO priceDAO;

    private static final Logger logger = Logger.getLogger(PriceServiceImpl.class);

    public PriceServiceImpl(PriceDAO priceDAO) {
        this.priceDAO = priceDAO;
    }

    public List<Price> findByCriteria(PriceCriteria priceCriteria){
        logger.info("PriceService.findByCriteria criteria: ".concat(priceCriteria.toString()));
        return this.priceDAO.findByCriteria(priceCriteria);
    }

}
