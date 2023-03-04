package com.chano.mvp.controller;

import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
import com.chano.mvp.service.PriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<Price> find(@ModelAttribute PriceCriteria priceCriteria){
        return this.priceService.getAll();
    }

}
