package com.ibmshop.productsapi.controllertest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ibmshop.productsapi.app.dto.input.CategoryDtoInsert;
import com.ibmshop.productsapi.domain.model.CategoryEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.jupiter.api.DisplayName;


@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {
	
	@Autowired
	private MockMvc mvc;
	@Autowired
	private JacksonTester<CategoryEntity> CategoryJsonInput;
	
	@Autowired
	private JacksonTester<CategoryDtoInsert> CategoryJsonOutputJson;

	
    @Test
    @DisplayName("Deverá devolver um erro 400")
    public void insert_controller_invalidData() throws Exception {
    	
    	var response = mvc.perform(post("/category")).andReturn().getResponse();
    	assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    	
    	
 
    }
    
    @Test
    @DisplayName("Deverá devolver um status 200")
    public void insert_controller_validData() throws Exception {
    	var nome = "VESTUÁRIO";
    	Long Long = null ;
		var response = mvc
				.perform(
						post("/category")
						.contentType(MediaType.APPLICATION_JSON)
						.content(CategoryJsonInput.write(
								new CategoryEntity(Long ,"Vestuário")
								).getJson())
						)
						.andReturn().getResponse();
    	assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    	
    	
 
    }
    
   
}