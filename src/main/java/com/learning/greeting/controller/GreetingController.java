package com.learning.greeting.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.greeting.exceptions.GreetingException;
import com.learning.greeting.service.GreetingService;
import com.learning.greeting.util.AccountCategory;

@RestController
@Validated
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	@RequestMapping("/greeting")
	public ResponseEntity<Object> showGreeting(@Valid @RequestParam(value = "id", defaultValue = "0") long id,
			@Valid @RequestParam(value = "type", defaultValue = "") String type,
			@Valid @RequestParam(value = "account", defaultValue = "", required = true) String account) {

		if (account.isBlank()) {
			throw new GreetingException("Required Account parameter is not present", HttpStatus.NOT_FOUND.value());
		}

		if (account.equalsIgnoreCase(AccountCategory.PERSONAL.toString()) && id == 0) {
			throw new GreetingException("Id parameter is not present", HttpStatus.NOT_FOUND.value());
		}

		if (account.equalsIgnoreCase(AccountCategory.BUSINESS.toString()) && type.isBlank()) {
			throw new GreetingException("Type parameter is not present", HttpStatus.NOT_FOUND.value());
		}

		return new ResponseEntity<>(greetingService.getGreetingMessage(id, account, type).toString(), HttpStatus.OK);
	}
}
