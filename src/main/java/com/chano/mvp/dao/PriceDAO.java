package com.chano.mvp.dao;

import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PriceDAO {

    public List<Price> findByCriteria(PriceCriteria criteria) {

        Price price = new Price();
        price.setPrice(new BigDecimal(100));
        price.setBrandId(Long.valueOf(1));
        price.setCurr("EUR");
        price.setPriority(Long.valueOf(1));
        price.setEndDate(new Date());
        price.setStartDate(new Date());
        price.setProductId(Long.valueOf(1));
        price.setPriceList(Long.valueOf(1));

        List<Price> lists = new ArrayList<Price>();
        lists.add(price);
        return lists;
    }

}
