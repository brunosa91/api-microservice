package com.ibmshop.userapi.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.mapper.UserMapperImpl;
import com.ibmshop.userapi.app.service.UserService;
import com.ibmshop.userapi.cross.exception.ValidationItemExist;
import com.ibmshop.userapi.domain.entities.UserEntity;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserMapperImpl mapper;


    @Test
    public void createUser_WithInvalidaData_ReturnBadRequest() throws Exception {

        UserEntity emptyUserEntity = new UserEntity();


        when(userService.insert(USER_DTO_INSERT)).thenReturn(USER);


        // act

        mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(emptyUserEntity))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isBadRequest());
    }

    @Test
    public void createUser_WithValidaData_ReturnCreated() throws Exception {

        when(userService.insert(USER_DTO_INSERT)).thenReturn(USER);


        // act

        mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(USER_DTO_INSERT))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isCreated())
                .andExpect(jsonPath("$").value("Usuário criado com sucesso"));
    }

    @Test
    public void createUser_WithExistCpt_ReturnConflict() throws Exception {


        when(userService.insert(any())).thenThrow(ValidationItemExist.class);


        // act

        mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(USER_DTO_OUTPUT))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isConflict());
    }

    @Test
    public void findUser_ByExistingId_ReturnUser() throws Exception {
        when(userService.findById(1L)).thenReturn(USER_DTO_OUTPUT);


        // executa o service pra poder testar o retorno dele pra controller.
        System.out.println(USER_DTO_OUTPUT);
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                //.andExpect(content().json(objectMapper.writeValueAsString(USER_DTO_OUTPUT)));
                .andExpect(jsonPath("$.nome").value(USER_DTO_OUTPUT.getNome()))
                .andExpect(jsonPath("$.sobrenome").value(USER_DTO_OUTPUT.getSobrenome()))
                .andExpect(jsonPath("$.cpf").value(USER_DTO_OUTPUT.getCpf()))
                .andExpect(jsonPath("$.telefone").value(USER_DTO_OUTPUT.getTelefone()));


        log.info(String.format("meu user dto saida " + USER_DTO_OUTPUT));
    }

    @Test
    public void findUser_ByUnexistingId_ReturnsNotFound() throws Exception {

        when(userService.findById(1L)).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isNotFound());
    }


    @Test
    public void findUser_ByExistingCpf_ReturnUser() throws Exception {
        when(userService.findByCpf("85182468067")).thenReturn(USER_DTO_OUTPUT);


        // executa o service pra poder testar o retorno dele pra controller.
        System.out.println(USER_DTO_OUTPUT);
        mockMvc.perform(get("/user/cpf?cpf=85182468067"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value(USER_DTO_OUTPUT.getNome()))
                .andExpect(jsonPath("$.sobrenome").value(USER_DTO_OUTPUT.getSobrenome()))
                .andExpect(jsonPath("$.cpf").value(USER_DTO_OUTPUT.getCpf()))
                .andExpect(jsonPath("$.telefone").value(USER_DTO_OUTPUT.getTelefone()));


        log.info(String.format("meu user dto saida " + USER_DTO_OUTPUT));
    }

    @Test
    public void findUser_ByUnexistingCpf_ReturnsNotFound() throws Exception {

        when(userService.findByCpf("85182468067")).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(get("/user/cpf?cpf=85182468067"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void findName_ByExistingName_ReturnUser() throws Exception {
        List<UserDtoOutput> userList = new ArrayList<>();

        userList.add(USER_DTO_OUTPUT);

        when(userService.findByName("bruno")).thenReturn(userList);

        mockMvc.perform(get("/user/nome?nome=bruno"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(USER_DTO_OUTPUT.getId()));


    }

    @Test
    public void findName_ByUneexistingName_ReturnBadRequest() throws Exception {


        when(userService.findByName("bruno")).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(get("/user/nome?nome=bruno"))
                .andExpect(status().isNotFound());


    }

    @Test
    public void findAll_ByExistingUser_ReturnUser() throws Exception {
        List<UserDtoOutput> userList = new ArrayList<>();

        userList.add(USER_DTO_OUTPUT);

        when(userService.findAll()).thenReturn(userList);

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(USER_DTO_OUTPUT.getId()));


    }

    @Test
    public void findAll_ByUnexistingUser_ReturnEmptyList() throws Exception {

        when(userService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

    }

    @Test
    public void updateUser_WithValidaData_ReturnUpdate() throws Exception {

//	when(userService.updateUser(USER_DTO_UPDATE,1L)).thenReturn(USER);
        //willDoNothing().given(userService).updateUser(USER_DTO_UPDATE,1L);
        doNothing().when(userService).updateUser(USER_DTO_UPDATE, 1L);

        // act

        mockMvc.perform(put("/user/updateuser/1").content(objectMapper.writeValueAsString(USER_DTO_INSERT))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk())
                .andExpect(jsonPath("$").value("Dados cadastrais do usuários atualizados"));
    }

    @Test
    public void updateUser_WithInvalidData_notFound() throws Exception {

//	when(userService.updateUser(USER_DTO_UPDATE,1L)).thenReturn(USER);
        //willDoNothing().given(userService).updateUser(USER_DTO_UPDATE,1L);
        //willThrow(EntityNotFoundException.class).given(userService).updateUser(USER_DTO_UPDATE,1L);

        doThrow(new EntityNotFoundException()).when(userService).updateUser(USER_DTO_UPDATE, 1L);


        // act

        mockMvc.perform(put("/user/updateuser/1").content(objectMapper.writeValueAsString(USER_DTO_UPDATE))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateUserIsActive_WithValidaData_ReturnUpdate() throws Exception {


        doNothing().when(userService).updadeUserActive(USER_DTO_UPDATE, 1L);


        // act

        mockMvc.perform(put("/user/updateativo/1").content(objectMapper.writeValueAsString(USER_DTO_UPDATE))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk())
                .andExpect(jsonPath("$").value("Status de ativo foi alterado com sucesso"));
    }


}