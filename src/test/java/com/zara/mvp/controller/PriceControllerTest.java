package com.zara.mvp.controller;

import com.zara.mvp.controller.dto.PriceDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Test 1: peticion a las 10:00 del dia 14 del producto 35455   para la brand 1 (ZARA)
     */
    @Test
    public void test1() throws Exception {
        final MvcResult result = this.mockMvc.perform(get("/prices?brandId=1&date=2020-06-14T10:00:00&productId=35455"))
                .andReturn();
        final List<PriceDTO> list = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PriceDTO>>() {});
        Assert.assertEquals(list.size() , 1);
    }

    /**
     *  Test 2: peticion a las 16:00 del dia 14 del producto 35455   para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        final MvcResult result = this.mockMvc.perform(get("/prices?brandId=1&date=2020-06-14T16:00:00&productId=35455"))
                .andReturn();
        final List<PriceDTO> list = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PriceDTO>>() {
        });
        Assert.assertEquals(list.size() , 2);
    }


    /**
     *  Test 3: peticion a las 21:00 del dia 14 del producto 35455   para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        final MvcResult result = this.mockMvc.perform(get("/prices?brandId=1&date=2020-06-14T21:00:00&productId=35455"))
                .andReturn();
        final List<PriceDTO> list = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PriceDTO>>() {
        });
        Assert.assertEquals(list.size() , 1);
    }

    /**
     *  Test 4: peticion a las 10:00 del dia 15 del producto 35455   para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        final MvcResult result = this.mockMvc.perform(get("/prices?brandId=1&date=2020-06-15T10:00:00&productId=35455"))
                .andReturn();
        final List<PriceDTO> list = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PriceDTO>>() {
        });
        Assert.assertEquals(list.size() , 2);
    }

    /**
     *  Test 5: peticion a las 21:00 del dia 16 del producto 35455   para la brand 1 (ZARA)
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        final MvcResult result = this.mockMvc.perform(get("/prices?brandId=1&date=2020-06-16T21:00:00&productId=35455"))
                .andReturn();
        final List<PriceDTO> list = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PriceDTO>>() {
        });
        Assert.assertEquals(list.size() , 2);
    }
}
