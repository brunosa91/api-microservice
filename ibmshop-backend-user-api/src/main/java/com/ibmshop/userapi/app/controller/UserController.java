package com.ibmshop.userapi.app.controller;

import java.net.URI;
import java.util.List;

import com.ibmshop.userapi.app.mapper.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import com.ibmshop.userapi.app.dto.output.UserDtoOutput;
import com.ibmshop.userapi.app.dto.update.UserDtoUpdate;
import com.ibmshop.userapi.app.service.UserService;
import com.ibmshop.userapi.domain.entities.UserEntity;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/user")
@Api(value = "User API")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserMapperImpl mapper;

    @GetMapping
    public ResponseEntity<List<UserDtoOutput>> findAll() {

        log.info(String.format("Output de  busca de todos users ${} "));

        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoOutput> findById(@PathVariable Long id) {

        log.info(String.format("Output de  busca pelo id ${} " + id));
        return ResponseEntity.ok(userService.findById(id));

    }

    @GetMapping("/nome{nome}")
    public ResponseEntity<List<UserDtoOutput>> SearchName(@RequestParam String nome) {

        log.info(String.format("Output de  busca pelo nome ${} " + nome));

        return ResponseEntity.ok(userService.findByName(nome));
    }

    @GetMapping("/cpf{cpf}")
    public ResponseEntity<UserDtoOutput> SearchCpf(@RequestParam String cpf) {
        log.info(String.format("Output de  busca pelo nome ${} " + cpf));

        return ResponseEntity.ok(userService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody @Valid UserDtoInsert userDto) {
        UserEntity userEntity = userService.insert(userDto);
        log.info(String.format("input de inserção ${} " + userEntity));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userEntity).toUri();
        return ResponseEntity.created(uri).body("Usuário criado com sucesso");
    }


    @PutMapping("/updateativo/{id}")
    public ResponseEntity<String> updateUserActive(@RequestBody UserDtoUpdate userDto, @PathVariable Long id) {
        userDto.setId(id);
        userService.updadeUserActive(userDto, id);

        log.info(String.format("update de userIsActive ${} " + id + userDto));

        return ResponseEntity.ok().body("Status de ativo foi alterado com sucesso");
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<String> updateUserAndAddress(@RequestBody UserDtoUpdate userDto, @PathVariable Long id) {
        userDto.setId(id);
        userService.updateUser(userDto, id);

        log.info(String.format("update de userIs ${} " + id + userDto));

        return ResponseEntity.ok().body("Dados cadastrais do usuários atualizados");
    }


}
