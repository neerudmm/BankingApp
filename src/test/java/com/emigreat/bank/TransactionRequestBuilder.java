package com.emigreat.bank;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequestBuilder {

	UUID accountId;
	double amount;

	public TransactionRequestBuilder withAccountId(UUID accountId) {
		this.accountId = accountId;
		return this;
	}
	
	public TransactionRequestBuilder withAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public TransactionRequestBuilder build() {
		return new TransactionRequestBuilder(accountId, amount);
	}
}
