package com.emigreat.bank.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emigreat.bank.entity.AccountTransactionHistory;
import com.emigreat.bank.entity.Accounts;
import com.emigreat.bank.pojo.TransactionRequest;
import com.emigreat.bank.repositories.AccountRepository;
import com.emigreat.bank.repositories.AccountTransactionHistoryRepository;
import com.emigreat.bank.service.AccountsTransactionHistoryService;
import com.emigreat.bank.util.TransactionType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountsTransactionHistoryServiceImpl implements AccountsTransactionHistoryService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountTransactionHistoryRepository accountTransactionHistoryRepository;

	public AccountTransactionHistory saveAccountsTransactionHistory(TransactionRequest transactionRequest,
			Accounts accounts) {

		log.info("Entered saveAccountsTransactionHistory method");
		AccountTransactionHistory accountTransactionHistory = new AccountTransactionHistory();

		accountTransactionHistory.setAccountId(accounts.getAccountId());
		accountTransactionHistory.setAmount(transactionRequest.getAmount());
		accountTransactionHistory.setTransactionDate(LocalDateTime.now());

		if (transactionRequest.getAmount() < 0) {
			accountTransactionHistory.setTransactionType(TransactionType.WITHDRAW.name());
		} else {
			accountTransactionHistory.setTransactionType(TransactionType.DEPOSIT.name());
		}

		accountTransactionHistoryRepository.save(accountTransactionHistory);

		log.info("Exit saveAccountsTransactionHistory method");
		return accountTransactionHistory;
	}

	@Override
	public Set<AccountTransactionHistory> getTransactionHistoryByAccountId(UUID accountId) {
		log.info("Entered getTransactionHistoryById method");

		Set<AccountTransactionHistory> accountTransactionHistories = accountTransactionHistoryRepository
				.findByAccountId(accountId);

		log.info("Exit getTransactionHistoryById method");
		return accountTransactionHistories; 
	}

	@Override
	public AccountTransactionHistory getTransactionHistoryById(UUID transactionId) {
		log.info("Entered getTransactionHistoryById method");

		AccountTransactionHistory accountTransactionHistory = accountTransactionHistoryRepository
				.findById(transactionId).get();

		log.info("Exit getTransactionHistoryById method");
		return accountTransactionHistory;
	}

	@Override
	public List<AccountTransactionHistory> getAllTransactionHistory() {
		log.info("Entered getAllTransactionHistory method");

		List<AccountTransactionHistory> accountTransactionHistories = accountTransactionHistoryRepository.findAll(Sort.by(Sort.Direction.DESC, "transactionDate"));

		log.info("Exit getAllTransactionHistory method");
		return accountTransactionHistories;
	}

}
