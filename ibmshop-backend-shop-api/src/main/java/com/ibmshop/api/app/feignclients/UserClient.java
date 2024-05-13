package com.ibmshop.api.app.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibmshop.api.app.dto.output.user.UserDtoOutput;




@Component
@FeignClient(name = "ibmshop-backend-user-api", url ="localhost:8001",path="/user")
public interface UserClient {
	@GetMapping("/{id}")
	ResponseEntity<UserDtoOutput> findById(@PathVariable Long id) ;
}
