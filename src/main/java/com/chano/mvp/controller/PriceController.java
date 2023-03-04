package com.chano.mvp.controller;

import com.chano.mvp.controller.dto.PriceDTO;
import com.chano.mvp.controller.dto.PriceParamDTO;
import com.chano.mvp.dao.filter.PriceCriteria;
import com.chano.mvp.model.Price;
import com.chano.mvp.service.PriceService;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<PriceDTO> find(@ModelAttribute PriceParamDTO priceParamDTO) {
        logger.info("PriceController.find with params: ".concat(priceParamDTO.toString()));
        List<Price> prices = this.priceService.findByCriteria(new PriceCriteria(priceParamDTO.getBrandId(),
                priceParamDTO.getDate(),
                priceParamDTO.getProductId()));
        return prices.stream().map(price -> new PriceDTO(price.getBrandId(),
                        price.getStartDate(), price.getEndDate(), price.getPriceList(),
                        price.getProductId(), price.getPriority(), price.getPrice(),
                        price.getCurr()))
                .collect(Collectors.toList());
    }


}
