package com.db.awmd.challenge.service;

import java.math.BigDecimal;

import com.db.awmd.challenge.exception.InsufficientBalenceException;

public interface TransactionService {
	public String transferAmount(String accountToId, String accountFromId, BigDecimal amount) throws InsufficientBalenceException;
}
