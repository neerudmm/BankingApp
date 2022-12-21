package com.emigreat.bank.repositories;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigreat.bank.entity.AccountTransactionHistory;

public interface AccountTransactionHistoryRepository extends JpaRepository<AccountTransactionHistory, Long> {

	@Query("select a from AccountTransactionHistory a where a.accountId = :accountId order by transactionDate desc ")
	Set<AccountTransactionHistory> findByAccountId(@Param("accountId")UUID accountId);

	Optional<AccountTransactionHistory> findById(UUID transactionId);

}
