package com.ibmshopbackenddiscount.discount.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshopbackenddiscount.discount.app.controller.ControllerCupom;
import com.ibmshopbackenddiscount.discount.app.dto.CupomRequest;
import com.ibmshopbackenddiscount.discount.app.mapper.CupomMapper;
import com.ibmshopbackenddiscount.discount.app.service.CupomService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.ibmshopbackenddiscount.discount.constant.constantCupom.*;


@Log4j2
@WebMvcTest(ControllerCupom.class)
public class cupomControllerTest {

    @MockBean
    private CupomService cupomService;

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CupomMapper cupomMapper;

    @Test
    public void createCupom_WithInvalidaData_ReturnBadRequest() throws Exception {

        CupomRequest emptyCupomRequest = new CupomRequest();


        when(cupomService.saveCupomService(CUPOM_REQUEST)).thenReturn(CUPOM_RESPONSE);


        // act

        mockMvc.perform(post("/cupons").content(objectMapper.writeValueAsString(emptyCupomRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isBadRequest());
    }

    @Test
    public void createCupom_WithValidaData_ReturnCreated() throws Exception {

        when(cupomService.saveCupomService(CUPOM_REQUEST)).thenReturn(CUPOM_RESPONSE);


        // act

        mockMvc.perform(post("/cupons").content(objectMapper.writeValueAsString(CUPOM_REQUEST))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isCreated())
                .andExpect(jsonPath("$.id").value(CUPOM_RESPONSE.getId()));
    }

    @Test
    public void findCupom_ByExistingId_ReturnCupom() throws Exception {
        when(cupomService.findCupomById(1L)).thenReturn(CUPOM_RESPONSE);


        // executa o service pra poder testar o retorno dele pra controller.
        System.out.println(CUPOM_RESPONSE);
        mockMvc.perform(get("/cupons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(CUPOM_RESPONSE.getId()));




    }

    @Test
    public void findCupom_ByUnexistingId_ReturnsNotFound() throws Exception {

        when(cupomService.findCupomById(1L)).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(get("/cupons/1"))
                .andExpect(status().isNotFound());
    }


    @Test
    public void updateCupom_ByExistingId_ReturnCupom() throws Exception {
        when(cupomService.updateCupom(CUPOM_REQUEST,1L)).thenReturn(CUPOM_RESPONSE);



        mockMvc.perform(put("/cupons/1"))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.id").value(CUPOM_RESPONSE.getId()));




    }


}
