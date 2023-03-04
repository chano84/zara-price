package com.chano.mvp.dao.filter;

import java.util.Date;

public class PriceCriteria{

    private Long brandId;

    private Date date;

    private Long productId;

    public PriceCriteria(Long brandId, Date date, Long productId){
        this.brandId = brandId;
        this.date = date;
        this.productId = productId;
    }
    
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "PriceCriteria{" +
                "brandId=" + brandId +
                ", date=" + date +
                ", productId=" + productId +
                '}';
    }
}
