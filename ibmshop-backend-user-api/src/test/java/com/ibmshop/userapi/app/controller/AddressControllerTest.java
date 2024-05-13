package com.ibmshop.userapi.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.mapper.AddressMapper;
import com.ibmshop.userapi.app.mapper.AddressMapperImpl;
import com.ibmshop.userapi.app.mapper.UserMapperImpl;
import com.ibmshop.userapi.app.service.AddressService;
import com.ibmshop.userapi.app.service.UserService;
import com.ibmshop.userapi.cross.exception.ValidationItemExist;
import com.ibmshop.userapi.domain.entities.Address;
import com.ibmshop.userapi.domain.entities.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ibmshop.userapi.common.UserConstant.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j2
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @MockBean
    private AddressService addressService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AddressMapperImpl mapper;


    @Test
    public void createAddress_WithInvalidaData_ReturnBadRequest() throws Exception {

        Address emptyUserEntity = new Address();


        when(addressService.insert(ADDRESS_DTO_INSERT)).thenReturn(ADDRESS);


        // act

        mockMvc.perform(post("/address").content(objectMapper.writeValueAsString(emptyUserEntity))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isBadRequest());
    }

    @Test
    public void createUser_WithValidaData_ReturnCreated() throws Exception {

        when(addressService.insert(ADDRESS_DTO_INSERT)).thenReturn(ADDRESS);


        // act

        mockMvc.perform(post("/address").content(objectMapper.writeValueAsString(ADDRESS_DTO_INSERT))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isCreated())
               .andExpect(jsonPath("$").value("Endereço criado com sucesso"));
    }

    @Test
    public void createAddress_WithExistNickName_ReturnConflict() throws Exception {


        when(addressService.insert(any())).thenThrow(ValidationItemExist.class);


        // act

        mockMvc.perform(post("/address").content(objectMapper.writeValueAsString(ADDRESS_DTO_OUTPUT))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isConflict());
    }

    @Test
    public void findAll_ByExistingAddress_ReturnAddress() throws Exception {
        List<AddressDtoOutput> userList = new ArrayList<>();

        userList.add(ADDRESS_DTO_OUTPUT);

        when(addressService.findAll()).thenReturn(userList);

        mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(ADDRESS_DTO_OUTPUT.getId()));


    }

    @Test
    public void findAll_ByUnexistingAddress_ReturnEmptyList() throws Exception {

        when(addressService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

    }


    @Test
    public void findAddress_ByExistingId_ReturnUser() throws Exception {
        when(addressService.findById(1L)).thenReturn(ADDRESS_DTO_OUTPUT);


        System.out.println(ADDRESS_DTO_OUTPUT);
        mockMvc.perform(get("/address/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ADDRESS_DTO_OUTPUT.getId()));



        log.info(String.format("meu user dto saida " + ADDRESS_DTO_OUTPUT));
    }

    @Test
    public void findAddress_ByUnexistingId_ReturnsNotFound() throws Exception {

        when(addressService.findById(1L)).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(get("/address/1"))
                .andExpect(status().isNotFound());
    }


    @Test
    public void findListAddressByUser_ByExistingUser_ReturnUser() throws Exception {
        List<AddressDtoOutput> addressList = new ArrayList<>();


        addressList.add(ADDRESS_DTO_OUTPUT);
        when(addressService.findByIdUser(1L)).thenReturn(addressList);


        // executa o service pra poder testar o retorno dele pra controller.
        System.out.println(ADDRESS_DTO_OUTPUT);
        mockMvc.perform(get("/address/user?id=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idUser").value(ADDRESS_DTO_OUTPUT.getIdUser()));



        log.info(String.format("meu user dto saida " + ADDRESS_DTO_OUTPUT));
    }

    @Test
    public void findListAddressByUser_ByUnexistingUser_ReturnNotFound() throws Exception {

        when(addressService.findByIdUser(1L)).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(get("/address/user?id=1"))
                .andExpectAll(status().isNotFound());


    }



    @Test
    public void updateAddress_WithValidaData_ReturnUpdate() throws Exception {


        doNothing().when(addressService).update(ADDRESS_DTO_UPDATE, 1L);

        // act

        mockMvc.perform(put("/address/1").content(objectMapper.writeValueAsString(ADDRESS_DTO_UPDATE))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk())
                .andExpect(jsonPath("$").value("Endereço atualizado com sucesso"));
    }

    @Test
    public void deleteAddress_WithExistinId_ReturnNoContent() throws Exception {



        mockMvc.perform(delete("/address/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteAddress_WithUnexistinId_ReturnNotFound() throws Exception {

        final Long addressId = 1L;
        doThrow(new EntityNotFoundException()).when(addressService).delete(addressId);

        mockMvc.perform(delete("/address/1"))
                .andExpect(status().isNotFound());
    }






}