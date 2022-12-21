package com.emigreat.bank.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Neeraja
 *
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum TransactionType {
	DEPOSIT("Deposit"), WITHDRAW("Withdraw");

	private String transactionType;
}
