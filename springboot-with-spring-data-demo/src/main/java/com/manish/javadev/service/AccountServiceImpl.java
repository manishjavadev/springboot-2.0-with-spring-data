package com.manish.javadev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.javadev.dao.AccountRepository;
import com.manish.javadev.model.AccountEntity;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public AccountEntity save(AccountEntity accountEntity) {
		AccountEntity acccountResult = accountRepository.save(accountEntity);
		return acccountResult;
	}

	@Override
	public AccountEntity find(Long accountNumber) {
		// TODO Auto-generated method stub
		Optional<AccountEntity> accounts = accountRepository.findById(accountNumber);
		if (accounts.isPresent()) {
			return accounts.get();
		} else {
			return null;
		}
	}

	@Override
	public Iterable<AccountEntity> saveAll(List<AccountEntity> accountEntities) {
		return accountRepository.saveAll(accountEntities);
	}

	@Override
	public void delete(Long accountNumber) {
		Optional<AccountEntity> accounts = accountRepository.findById(accountNumber);
		if (accounts.isPresent()) {
			accountRepository.delete(accounts.get());
		}
	}

	@Override
	public AccountEntity update(AccountEntity accountEntity) {
		Optional<AccountEntity> accounts = accountRepository.findById(accountEntity.getAccountNumber());
		if (accounts.isPresent()) {
			return accountRepository.save(accountEntity);
		}
		return null;
	}
}
