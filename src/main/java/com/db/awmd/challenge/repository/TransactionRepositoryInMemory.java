package com.db.awmd.challenge.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db.awmd.challenge.domain.Account;

@Repository
public class TransactionRepositoryInMemory implements TransactionRepository {

	@Autowired
	AccountsRepository accountRepositoryInMemory;

	@Override
	public void performTransaction(Account account) {
		
		Map<String, Account> accounts = accountRepositoryInMemory.getAccounts();
		accounts.put(account.getAccountId(), account);
		
	}
}
