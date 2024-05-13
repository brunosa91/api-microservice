package com.ibmshop.api.domain.entity;

public enum Status {
	
	 AGPAGAMENTO,
	    EFETUADO,
	    PROCESSADO,
	    CONCLUIDO,
	    CANCELADO;
	
	/*
	 AGPAGAMENTO(1),
	    EFETUADO(2),
	    PROCESSADO(3),
	    CONCLUIDO(4),
	    CANCELADO(5);

	    private final int valor;

	    Status(int valor) {
	        this.valor = valor;
	    }

	    public int getValor() {
	        return valor;
	    }
	    
	    public static Status valueOfInt(int code) {
	    	for(Status status : Status.values()) {
	    		
	    		 if(status.getValor()== code) {
	    			 return status;
	    		 }
	    	}
	    	throw new IllegalArgumentException("Invalid Order Statys coder");
	    }
	    */
}
