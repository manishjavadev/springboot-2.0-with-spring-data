package com.manish.javadev.service;

import java.util.List;

import com.manish.javadev.model.AccountEntity;

public interface AccountService {

	AccountEntity save(AccountEntity accountEntity);

	AccountEntity find(Long accountNumber);

	Iterable<AccountEntity> saveAll(List<AccountEntity> accountEntities);

	void delete(Long long1);

	AccountEntity update(AccountEntity accountEntity);

}