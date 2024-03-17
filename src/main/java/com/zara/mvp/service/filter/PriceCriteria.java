package com.zara.mvp.service.filter;

import java.time.LocalDateTime;

public class PriceCriteria{

    private Long brandId;

    private LocalDateTime date;

    private Long productId;

    public PriceCriteria(Long brandId, LocalDateTime date, Long productId){
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
