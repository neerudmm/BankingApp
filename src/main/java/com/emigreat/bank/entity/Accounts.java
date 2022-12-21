package com.emigreat.bank.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "ACCOUNTS", schema = "BANK")
public class Accounts {

	@Id
	@Column(name = "ACCOUNT_ID", length = 50, nullable = false, unique = true)
	@Type(type="uuid-char")
	private UUID accountId;

	@Column(name = "BALANCE", nullable = false, unique = false)
	private double balance;

	@OneToMany
	@JoinColumn(name = "ACCOUNT_ID")
	@JsonManagedReference
	private Set<AccountTransactionHistory> accountTransactionHistories;

}
