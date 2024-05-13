package com.ibmshop.userapi.app.service;

import java.util.List;

import com.ibmshop.userapi.app.dto.input.AddressDtoInsert;
import com.ibmshop.userapi.app.dto.output.AddressDtoOutput;
import com.ibmshop.userapi.app.dto.update.AddressDtoUpdate;
import com.ibmshop.userapi.domain.entities.Address;
import jakarta.transaction.Transactional;


public interface AddressInterface {

	
	List<AddressDtoOutput>  findAll();
		
	AddressDtoOutput findById(Long id);
	
	List<AddressDtoOutput> findByIdUser(Long id);

	Address insert(AddressDtoInsert addressDtoInsert);

	void update(AddressDtoUpdate addressDtoUpdate, Long id);


	void delete(Long id);
	

	
	

}
