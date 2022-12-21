package com.emigreat.bank.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emigreat.bank.entity.Accounts;
import com.emigreat.bank.pojo.AccountsResponse;
import com.emigreat.bank.pojo.TransactionRequest;
import com.emigreat.bank.repositories.AccountRepository;
import com.emigreat.bank.repositories.AccountTransactionHistoryRepository;
import com.emigreat.bank.service.AccountsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountTransactionHistoryRepository accountTransactionHistoryRepository;

	public Accounts saveAccounts(TransactionRequest transactionRequest) {

		log.info("Entered saveAccounts method");
		Accounts accounts = accountRepository.findByAccountId(transactionRequest.getAccountId());
		if (accounts == null) {
			accounts = new Accounts();
			accounts.setAccountId(transactionRequest.getAccountId());
		}

		double totalBalance = accounts.getBalance() + transactionRequest.getAmount();

		accounts.setBalance(totalBalance);

		log.info("Exit saveAccounts method");
		return accountRepository.save(accounts);
	}

	public AccountsResponse getAccountsById(UUID accountId) {

		Accounts accounts = accountRepository.findByAccountId(accountId);
		AccountsResponse accountsResponse = AccountsResponse.builder().accountId(accounts.getAccountId())
				.amount(accounts.getBalance()).build();

		return accountsResponse;
	}

	@Override
	public List<Accounts> getAllAccounts() {
		log.info("Entered getAllAccounts method");

		List<Accounts> accounts = accountRepository.findAll();

		log.info("Exit getAllAccounts method");
		return accounts;
	}

}
