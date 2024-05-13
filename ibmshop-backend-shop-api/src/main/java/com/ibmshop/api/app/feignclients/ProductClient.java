package com.ibmshop.api.app.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibmshop.api.app.dto.output.product.ProductDtoOutput;




@Component
@FeignClient(name = "ibmshop-backend-products-api", url ="localhost:8101",path="/product")
public interface ProductClient {
	@GetMapping("/{id}")
	public ResponseEntity<ProductDtoOutput> findById(@PathVariable Long id);
}
