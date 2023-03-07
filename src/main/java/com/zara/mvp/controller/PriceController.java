package com.zara.mvp.controller;

import com.zara.mvp.controller.dto.PriceDTO;
import com.zara.mvp.domain.Price;
import com.zara.mvp.service.PriceService;
import com.zara.mvp.service.filter.PriceCriteria;
import com.zara.mvp.service.mapper.PricesMapper;
import org.jboss.logging.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private static final Logger logger = Logger.getLogger(PriceController.class);

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<PriceDTO> find(
            @RequestParam(name = "date" , required=false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date,
            @RequestParam(name = "brandId", required=false) Long brandId,
            @RequestParam(name = "productId", required=false) Long productId
           ) {
        PriceCriteria criteria = new PriceCriteria(brandId,date,productId);
        logger.info("PriceController.find with params: ".concat(criteria.toString()));
        PricesMapper pricesMapper = new PricesMapper();
        List<Price> prices = this.priceService.findByCriteria(criteria);
        return prices.stream().map(price -> pricesMapper.toDTO(price))
                .collect(Collectors.toList());
    }


}
