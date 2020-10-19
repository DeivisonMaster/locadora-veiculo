package br.com.locadora.util;

public class ErroConstraintException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ErroConstraintException(String msg, Throwable causa) {
		super(msg, causa);
	}

}
