package com.emigreat.bank.pojo;

import java.util.Set;
import java.util.UUID;

import com.emigreat.bank.entity.AccountTransactionHistory;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Model to create a new Transaction Response")
public class TransactionResponse {

    private String errorCode;
    private String errorMsg;    
    private String message;    
    private UUID transactionId;
    private UUID accountId;
    private double amount;
    Set<AccountTransactionHistory> transactionHistories;
    
    
}
