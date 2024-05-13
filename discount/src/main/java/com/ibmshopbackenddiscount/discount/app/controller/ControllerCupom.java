package com.ibmshopbackenddiscount.discount.app.controller;

import com.ibmshopbackenddiscount.discount.app.dto.CupomRequest;
import com.ibmshopbackenddiscount.discount.app.dto.CupomResponse;
import com.ibmshopbackenddiscount.discount.app.service.CupomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cupons")
@RequiredArgsConstructor
@Slf4j
public class ControllerCupom {
    private final CupomService cupomService;
    @PostMapping
    public ResponseEntity<CupomResponse> insert(@RequestBody @Valid CupomRequest cupomRequest){

        log.info(String.format("ENTRADA CUPOM REQUEST NO INSERT NA CONTROLLER %s,",cupomRequest));

        CupomResponse cupomResponse = cupomService.saveCupomService(cupomRequest);
        log.info(String.format("RETORNO CUPOMRESPONSE NO INSERT NA CONTROLLER %s,",cupomResponse));
        URI uri = UriComponentsBuilder.fromPath("/cupons/{id}").buildAndExpand(cupomResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(cupomResponse);

    }

    //TODO FAZER SWAGGER DE DISCOUNT
    @PutMapping(value = "/{id}")
    public ResponseEntity<CupomResponse> updateCupom(@RequestBody @Validated CupomRequest cupomRequest,@PathVariable("id") Long id ){

        log.info(String.format("ENTRADA CUPOM REQUEST NO UPDATE NA CONTROLLER %s e o ID %s,",cupomRequest,id));

        CupomResponse cupomResponse = cupomService.updateCupom(cupomRequest,id);

        log.info(String.format("RETORNO CUPOM RESPONSE NO UPDATE NA CONTROLLER %s e o ID %s,",cupomResponse, id));

        return ResponseEntity.ok().body(cupomResponse);
    }

    @PutMapping(value = "desativar/{id}")
    public  ResponseEntity<String> desativarCupom(@RequestBody @Validated CupomRequest cupomRequest, @PathVariable("id")Long id){

        log.info(String.format("ENTRADA CUPOM REQUEST NO DESATIVA CUPOM NA CONTROLLER %s,",cupomRequest));

        CupomResponse cupomResponse =  cupomService.desativarCupom(cupomRequest,id);

        log.info(String.format("RETORNO CUPOM RESPONSE NO DESATIVA CUPOM NA CONTROLLER %s,",cupomResponse));

        return ResponseEntity.ok().body("Cupom desativado");
    }




    @GetMapping(value = "/{id}")
    public ResponseEntity<CupomResponse> findCupomById(@PathVariable Long id){

        CupomResponse cupomResponse = cupomService.findCupomById(id);

        log.info(String.format("RETORNO CUPOM RESPONSE FIND CUPOM BY ID NA CONTROLLER %s,",cupomResponse));

        return ResponseEntity.ok(cupomResponse);
    }
}
