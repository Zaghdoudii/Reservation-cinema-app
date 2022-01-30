package com.msglc.services;

public class PlusDePlaceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlusDePlaceException() {
		System.out.print(" Pas de places disponibles :( ");
	}
	
	public PlusDePlaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PlusDePlaceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlusDePlaceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PlusDePlaceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
