package com.emigreat.bank.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emigreat.bank.entity.Accounts;
import com.emigreat.bank.pojo.AccountsResponse;
import com.emigreat.bank.pojo.TransactionRequest;

@Service
public interface AccountsService {

	public Accounts saveAccounts(TransactionRequest accountTransactionRequest);

	public AccountsResponse getAccountsById(UUID accountId);

	public List<Accounts> getAllAccounts();

}
