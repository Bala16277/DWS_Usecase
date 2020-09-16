package com.db.awmd.challenge.exception;

import java.math.BigDecimal;

public class InsufficientBalenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalenceException(BigDecimal amount) {

		super(String.format("Insufficient amount, current balence is %.2f", amount));
	}
}
