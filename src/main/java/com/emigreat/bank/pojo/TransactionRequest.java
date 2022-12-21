package com.emigreat.bank.pojo;

import java.util.UUID;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Model to create a new Transaction Request")
public class TransactionRequest {
   
	UUID accountId;
	double amount;
	
}
