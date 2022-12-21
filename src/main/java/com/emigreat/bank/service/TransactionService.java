package com.emigreat.bank.service;

import org.springframework.stereotype.Service;

import com.emigreat.bank.pojo.TransactionRequest;
import com.emigreat.bank.pojo.TransactionResponse;

@Service
public interface TransactionService {

	public TransactionResponse perfromTransaction(TransactionRequest accountTransactionRequest);

}
