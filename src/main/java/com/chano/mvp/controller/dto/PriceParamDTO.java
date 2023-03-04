package com.chano.mvp.controller.dto;

import java.util.Date;

public class PriceParamDTO {

    private Long productId;

    private Date date;

    private Long brandId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "PriceParamDTO{" +
                "productId=" + productId +
                ", date=" + date +
                ", brandId=" + brandId +
                '}';
    }
}
