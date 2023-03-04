package com.chano.mvp.dao;

import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Price> cq = cb.createQuery(Price.class);
        Root<Price> root = cq.from(Price.class);

        List<Predicate> predicateList = new ArrayList<Predicate>();
        if (criteria.getProductId() != null) {
            predicateList.add(cb.equal(root.get("productId"), criteria.getProductId()));
        }
        if (criteria.getBrandId() != null) {
            predicateList.add(cb.equal(root.get("brandId"), criteria.getBrandId()));
        }
        if (criteria.getDate() != null) {
            predicateList.add(cb.greaterThan(root.get("start_date"), criteria.getDate()));
            predicateList.add(cb.lessThan(root.get("end_date"), criteria.getDate()));
        }

        Predicate[] predicates =  predicateList.toArray(new Predicate[predicateList.size()]);
        Predicate predicateResult = cb.and(predicates);

        cq.select(root).where(predicateResult);
        Query<Price> query = session.createQuery(cq);
        return query.getResultList();
    }

}
