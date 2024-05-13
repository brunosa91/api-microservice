package com.ibmshop.userapi.cross.exception;

import lombok.Getter;

@Getter
public class ValidationItemExist extends RuntimeException {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String campo;

    public ValidationItemExist(String campo, String message) {
        super(message);
        this.campo = campo;
    }


    
 
}
