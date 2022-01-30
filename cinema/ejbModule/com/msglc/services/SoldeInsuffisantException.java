package com.msglc.services;

public class SoldeInsuffisantException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SoldeInsuffisantException() {
		System.out.print("Solde Insuffisant :( ");
	}
	public SoldeInsuffisantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SoldeInsuffisantException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SoldeInsuffisantException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SoldeInsuffisantException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
