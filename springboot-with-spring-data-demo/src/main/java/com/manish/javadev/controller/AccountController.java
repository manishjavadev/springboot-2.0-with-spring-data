package com.manish.javadev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.service.AccountService;

/**
 * @author Manish
 * 
 *         http://localhost:8081/api/ping
 * 
 *         http://localhost:8081/api/account/2
 * 
 *         http://localhost:8081/api/account
 *
 */
@RestController
@RequestMapping(value = "/api")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "Configuration is working...";
	}

	@RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.GET)
	public ResponseEntity<AccountEntity> find(@PathVariable("accountNumber") Long accountNumber) {
		System.out.println("findAccount called............");
		AccountEntity accountEntity = accountService.find(new Long(accountNumber));
		System.out.println("accountEntity  =:" + accountEntity);
		return new ResponseEntity<AccountEntity>(accountEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public ResponseEntity<AccountEntity> save(@RequestBody AccountEntity accountEntity) {
		AccountEntity entity = accountService.save(accountEntity);
		return new ResponseEntity<AccountEntity>(entity, HttpStatus.OK);
	}

	@RequestMapping(value = "/account", method = RequestMethod.PUT)
	public ResponseEntity<AccountEntity> update(@RequestBody AccountEntity accountEntity) {
		AccountEntity entity = accountService.update(accountEntity);
		return new ResponseEntity<AccountEntity>(entity, HttpStatus.OK);
	}

	@RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.DELETE)
	public ResponseEntity<AccountEntity> delete(@PathVariable("accountNumber") Long accountNumber) {
		System.out.println("findAccount called............");
		accountService.delete(new Long(accountNumber));
		return new ResponseEntity<AccountEntity>(HttpStatus.OK);
	}

}