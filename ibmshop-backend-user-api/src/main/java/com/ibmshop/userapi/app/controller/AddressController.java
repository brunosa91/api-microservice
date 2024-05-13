package com.ibmshop.userapi.app.controller;


import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
import com.ibmshop.userapi.app.service.AddressService;
import com.ibmshop.userapi.domain.entities.Address;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import lombok.extern.log4j.Log4j2;

import java.net.URI;
import java.util.List;
@Log4j2
@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressDtoOutput>> findaAll() {

        log.info(String.format("output de todos os endereços ${} " ));

        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDtoOutput> findById(@PathVariable Long id) {

        log.info(String.format("output de busca por id do endereço ${} " +id));

        return ResponseEntity.ok((AddressDtoOutput) addressService.findById(id));

    }

    ;

    @GetMapping(value = "/user{id}")
    public ResponseEntity<List<AddressDtoOutput>> findByIdUser(@RequestParam Long id) {

        log.info(String.format("output de busca da list de endereço por id do usuário ${} " +id));

        return ResponseEntity.ok(addressService.findByIdUser(id));

    }

    ;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody @Valid AddressDtoInsert addressDtoInsertObj) {
        Address addressObj = addressService.insert(addressDtoInsertObj);

        log.info(String.format("input de inserção do endereço ${} " + addressObj));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressObj).toUri();
        return ResponseEntity.created(uri).body("Endereço criado com sucesso");
    }

    ;

    @PutMapping(value = "/{id}")

    public ResponseEntity<String> updateAddress(@RequestBody @Valid AddressDtoUpdate addressDtoUpdate, @PathVariable Long id) {
        addressDtoUpdate.setId(id);
        addressService.update(addressDtoUpdate, id);
        log.info(String.format("update  de endereço ${} " + addressDtoUpdate + id));

        return ResponseEntity.ok().body("Endereço atualizado com sucesso");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);

        log.info(String.format("deleção de endereço ${} " + id));

        return ResponseEntity.noContent().build();

    }
}
