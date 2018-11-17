package com.cg.ams.exception;

public class AMSException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;

	public AMSException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public AMSException() {
	}

}
