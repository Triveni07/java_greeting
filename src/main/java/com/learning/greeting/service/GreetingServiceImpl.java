package com.learning.greeting.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.learning.greeting.exceptions.GreetingException;
import com.learning.greeting.model.Greeting;
import com.learning.greeting.util.AccountCategory;
import com.learning.greeting.util.AccountType;

@Service
public class GreetingServiceImpl implements GreetingService {

	private static String template = "";
	private static String result = "";

	/*
	 * This method takes arguments as long id, String Account and String type
	 * to get the greeting message by checking the different conditions
	 * and returns greeting appropriate message 
	 */
	@Override
	public Greeting getGreetingMessage(long id, String account, String type) {
		AccountCategory enumAccount;
		AccountType enumType;
		try {
			enumAccount = AccountCategory.valueOf(account.toUpperCase());

			if (enumAccount == AccountCategory.BUSINESS) {
				enumType = AccountType.valueOf(type.toUpperCase());

				switch (enumType) {
				case SMALL:
					throw new GreetingException("Path is not yet implemented", HttpStatus.NOT_IMPLEMENTED.value());

				case BIG:
					template = "Welcome, %s user!";
					result = String.format(template, account);
					break;

				default:
				}

			} else {
				if (id > 0) {
					template = "Hi, userId %d";
					result = String.format(template, id);

				} else
					throw new GreetingException("ID must be a positive integer", HttpStatus.BAD_REQUEST.value());
			}

		} catch (IllegalArgumentException e) {
			template = String.format("Invalid parameter values.. Allowed combinations are Id as positive integer, "
					+ "Account as Business or Personal and Type as Big or Small ");

			throw new GreetingException(template, HttpStatus.BAD_REQUEST.value());
		}

		Greeting greeting = new Greeting(result);
		return greeting;
	}
}
