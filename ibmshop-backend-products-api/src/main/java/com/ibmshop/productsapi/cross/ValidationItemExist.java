package com.ibmshop.productsapi.cross;

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
    
    
    public String getCampo() {
		return campo;
	}
}
