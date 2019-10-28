package com.learning.greeting.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.greeting.exceptions.GreetingException;
import com.learning.greeting.model.Greeting;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class GreetingServiceTests {
	@Autowired
	private GreetingService greetingService;

	@Test
	public void whenValidParametersAreProvided_thenRetrievedGreetingIsCorrect() {
		Mockito.when(greetingService.getGreetingMessage(123, "personal", ""))
				.thenReturn(new Greeting("Hi, userId 123!"));
		String testGreetingMessage = greetingService.getGreetingMessage(123, "personal", "").toString();

		String expected = "Hi, userId 123!";
		Assert.assertEquals(expected, testGreetingMessage);
	}

	@Test
	public void whenValidParameterCombinationsAreProvided_thenRetrievedGreetingIsCorrect() {
		Mockito.when(greetingService.getGreetingMessage(1, "business", "big"))
				.thenReturn(new Greeting("Welcome, business user!"));
		String testGreetingMessage = greetingService.getGreetingMessage(1, "business", "big").toString();

		String expected = "Welcome, business user!";
		Assert.assertEquals(expected, testGreetingMessage);
	}

	/*
	 * @Test public void whenInvalidParametersAreProvided_thenThrowError() {
	 * Mockito.when(greetingService.getGreetingMessage(-1, "personal", "small"))
	 * .thenThrow(new GreetingException("ID must be a positive integer",
	 * HttpStatus.BAD_REQUEST.value()));
	 * 
	 * Greeting error = greetingService.getGreetingMessage(-1, "personal", "small");
	 * Assert.assertEquals(RuntimeException.class, error); }
	 * 
	 * @Test public void
	 * whenInvalidParametersCombinationsAreProvided_thenThrowError() {
	 * 
	 * String template = String.format("Invalid parameter values..");
	 * 
	 * Mockito.when(greetingService.getGreetingMessage(2, "personal", "small"))
	 * .thenThrow(new GreetingException(template, HttpStatus.BAD_REQUEST.value()));
	 * 
	 * Greeting error = greetingService.getGreetingMessage(2, "personal", "small");
	 * Assert.assertEquals(RuntimeException.class, error); Assert.fail(template); ;
	 * }
	 */
}
