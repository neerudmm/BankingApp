package com.emigreat.bank.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emigreat.bank.entity.AccountTransactionHistory;
import com.emigreat.bank.entity.Accounts;
import com.emigreat.bank.pojo.TransactionRequest;

@Service
public interface AccountsTransactionHistoryService {

	public AccountTransactionHistory saveAccountsTransactionHistory(TransactionRequest accountTransactionRequest,Accounts accounts);

	public AccountTransactionHistory getTransactionHistoryById(UUID transactionId);
	
	public Set<AccountTransactionHistory> getTransactionHistoryByAccountId(UUID accountId);
	
	public List<AccountTransactionHistory> getAllTransactionHistory();


}
