package com.chano.mvp.dao;

import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceDAO {

    private static final Logger logger = Logger.getLogger(PriceDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    public List<Price> findByCriteria(PriceCriteria criteria) {
        logger.debug("PriceDAO.findByCriteria.begin");
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
        Predicate predicateResult = cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        cq.select(root).where(predicateResult);
        logger.debug("PriceDAO.findByCriteria.end");
        return session.createQuery(cq).getResultList();
    }

}
