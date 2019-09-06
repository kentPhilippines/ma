package com.pay.gateway.config.exception;

public class OtherErrors extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public	OtherErrors(){}
	public OtherErrors(String message){
        super(message);
    }
}
