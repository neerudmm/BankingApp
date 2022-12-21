package com.emigreat.bank.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT_TRANSACTION_HISTORY", schema = "BANK")
public class AccountTransactionHistory {

	@Id
	@Column(name = "ID", nullable = false, unique = false)
	@Type(type="uuid-char")
	private UUID id = UUID.randomUUID();
	
	@Column(name = "ACCOUNT_ID", nullable = false, unique = false)
	@Type(type="uuid-char")
	private UUID accountId;

	@Column(name = "AMOUNT", length = 50, nullable = false, unique = false)
	private double amount;

	@Column(name = "TRANSACTION_TYPE", nullable = false, unique = false)
	private String transactionType;

	@Column(name = "TRANSACTION_DATE", nullable = false, unique = false)
	private LocalDateTime transactionDate;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID", insertable = false, updatable = false)
	@JsonBackReference
	private Accounts accounts;

}
