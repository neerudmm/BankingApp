package com.emigreat.bank;

import java.util.UUID;

public class TransactionRequestFixture {

	public final static TransactionRequestBuilder TEST_DEPOSIT = new TransactionRequestBuilder()
			.withAccountId(UUID.randomUUID()).withAmount(1000).build();
	
	public final static TransactionRequestBuilder TEST_WITHDAWAL = new TransactionRequestBuilder()
			.withAccountId(UUID.randomUUID()).withAmount(-500).build();
	
}
