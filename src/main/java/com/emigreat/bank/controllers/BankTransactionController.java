package com.emigreat.bank.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emigreat.bank.entity.AccountTransactionHistory;
import com.emigreat.bank.entity.Accounts;
import com.emigreat.bank.exceptions.ResourceNotFoundException;
import com.emigreat.bank.pojo.AccountsResponse;
import com.emigreat.bank.pojo.TransactionRequest;
import com.emigreat.bank.pojo.TransactionResponse;
import com.emigreat.bank.service.AccountsService;
import com.emigreat.bank.service.AccountsTransactionHistoryService;
import com.emigreat.bank.service.TransactionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BankTransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AccountsService accountsService;

	@Autowired
	private AccountsTransactionHistoryService accountsTransactionHistoryService;

	@PostMapping("transactions")
	@ApiOperation(value = "transactions", notes = " Deposit/Withdraw Money ")
	public ResponseEntity<TransactionResponse> perfromTransaction(
			@ApiParam(value = "accountTransactionRequest", required = true) @RequestBody TransactionRequest transactionRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<TransactionResponse>(transactionService.perfromTransaction(transactionRequest), HttpStatus.OK);
	}

	@GetMapping("/transactions/{id}")
	public ResponseEntity<AccountTransactionHistory> getTransactionHistoryById(
			@PathVariable(value = "id") final UUID transactionId) throws ResourceNotFoundException {

		AccountTransactionHistory accountTransactionHistory = accountsTransactionHistoryService
				.getTransactionHistoryById(transactionId);

		return new ResponseEntity<AccountTransactionHistory>(accountTransactionHistory, HttpStatus.OK);
	}

	@GetMapping("/transactions")
	public ResponseEntity<List<AccountTransactionHistory>> getAllTransactionHistory() throws ResourceNotFoundException {

		List<AccountTransactionHistory> accountTransactionHistory = accountsTransactionHistoryService
				.getAllTransactionHistory();

		return new ResponseEntity<List<AccountTransactionHistory>>(accountTransactionHistory, HttpStatus.OK);
	}

	@GetMapping("/accounts/{id}")
	public ResponseEntity<AccountsResponse> getAccountsById(@PathVariable(value = "id") final UUID accountId)
			throws ResourceNotFoundException {

		AccountsResponse accountTransactionHistory = accountsService.getAccountsById(accountId);

		return new ResponseEntity<AccountsResponse>(accountTransactionHistory, HttpStatus.OK);
	}

	@GetMapping("/accounts")
	public ResponseEntity<List<Accounts>> getAllAccounts() throws ResourceNotFoundException {

		List<Accounts> accounts = accountsService.getAllAccounts();

		return new ResponseEntity<List<Accounts>>(accounts, HttpStatus.OK);
	}

}
