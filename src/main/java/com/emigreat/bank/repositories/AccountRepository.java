package com.emigreat.bank.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emigreat.bank.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

	Accounts findByAccountId(UUID accountId);
}
