package com.emigreat.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emigreat.bank.entity.Accounts;
import com.emigreat.bank.pojo.TransactionRequest;
import com.emigreat.bank.pojo.TransactionResponse;
import com.emigreat.bank.repositories.AccountRepository;
import com.emigreat.bank.repositories.AccountTransactionHistoryRepository;
import com.emigreat.bank.service.AccountsService;
import com.emigreat.bank.service.AccountsTransactionHistoryService;
import com.emigreat.bank.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Neeraja
 *
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountsService accountsService;

	@Autowired
	AccountsTransactionHistoryService accountsTransactionHistoryService;

	@Autowired
	AccountTransactionHistoryRepository accountTransactionHistoryRepository;

	public TransactionResponse perfromTransaction(TransactionRequest transactionRequest) {

		log.info("Entered perfromTransaction method");
		String message = "";

		Accounts accounts = accountsService.saveAccounts(transactionRequest);
		accountsTransactionHistoryService.saveAccountsTransactionHistory(transactionRequest, accounts);

		if (transactionRequest.getAmount() < 0) {
			message = "Transferred " + (transactionRequest.getAmount() * -1) + "$ from Account "
					+ transactionRequest.getAccountId();
		} else {
			message = "Transferred " + transactionRequest.getAmount() + "$ to Account "
					+ transactionRequest.getAccountId();
		}
		TransactionResponse transactionResponse = TransactionResponse.builder().errorCode(null).errorMsg(null).message(message)
				.transactionId(null).accountId(transactionRequest.getAccountId()).amount(transactionRequest.getAmount())
				.transactionHistories(accountsTransactionHistoryService.getTransactionHistoryByAccountId(transactionRequest.getAccountId())).build();

		log.info("Exit perfromTransaction method");
		return transactionResponse;
	}

}
