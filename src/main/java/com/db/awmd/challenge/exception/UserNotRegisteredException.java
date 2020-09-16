package com.db.awmd.challenge.exception;

public class UserNotRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotRegisteredException() {

		super("Account is not registered");
		
	}
}
