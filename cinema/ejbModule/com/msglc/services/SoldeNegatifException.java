package com.msglc.services;

public class SoldeNegatifException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SoldeNegatifException() {
		System.out.print(" Votre solde n'est pas suffisant :( ");
	}
	
	public SoldeNegatifException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SoldeNegatifException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SoldeNegatifException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SoldeNegatifException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
