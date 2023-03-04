package com.chano.mvp.controller;

import com.chano.mvp.controller.dto.PriceDTO;
import com.chano.mvp.controller.dto.PriceParamDTO;
import com.chano.mvp.domain.Price;
import com.chano.mvp.service.PriceService;
import com.chano.mvp.service.mapper.PricesMapper;
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
        PricesMapper pricesMapper = new PricesMapper();
        List<Price> prices = this.priceService.findByCriteria(pricesMapper.toPriceCriteria(priceParamDTO));
        return prices.stream().map(price -> pricesMapper.toDTO(price))
                .collect(Collectors.toList());
    }


}
