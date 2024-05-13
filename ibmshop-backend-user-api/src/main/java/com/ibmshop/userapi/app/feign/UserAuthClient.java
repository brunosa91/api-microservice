package com.ibmshop.userapi.app.feign;

import com.ibmshop.userapi.app.dto.client.UserCredentialDtoInsert;
import com.ibmshop.userapi.app.dto.input.UserDtoInsert;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Component
@FeignClient(name = "ibmshop-backend-auth-service", url ="localhost:8015",path="/auth")
public interface UserAuthClient {
	@PostMapping("/user")
	ResponseEntity<UserCredentialDtoInsert> inserUserCredential(@RequestBody UserCredentialDtoInsert userCredentialDtoInsert) ;
}
