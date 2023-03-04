package com.chano.mvp.dao;

import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PriceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Price> getAll(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Price> cq = cb.createQuery(Price.class);
        Root<Price> root = cq.from(Price.class);
        cq.select(root);
        Query<Price> query = session.createQuery(cq);
        return query.getResultList();
    }

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
