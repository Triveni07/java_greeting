package com.learning.greeting.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class GreetingControllerTests extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void greetWhenAccountIsPersonalWithGivenId() throws Exception {
		String uri = "/greeting?id=123&account=personal";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();

		String content = "Hi, userId 123";
		assertEquals(content, response);
	}

	@Test
	public void greetWhenAccountIsBusinessAndTypeIsBig() throws Exception {
		String uri = "/greeting?type=big&account=business";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();

		String content = "Welcome, business user!";
		assertEquals(content, response);
	}

	@Test
	public void whenAccountIsBusinessAndTypeIsBig_thenReturnErrorMessage() throws Exception {
		String uri = "/greeting?type=small&account=business";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		String expectedErrorDetails = "{\"message\":\"Path is not yet implemented\",\"status\":501}";
		assertEquals(expectedErrorDetails, response);
	}

	@Test
	public void whenAccountIsMissing_thenReturnBadRequestMessage() throws Exception {
		String uri = "/greeting";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		String expectedErrorDetails = "{\"message\":\"Required Account parameter is not present\",\"status\":404}";
		assertEquals(expectedErrorDetails, response);
	}

	@Test
	public void whenAccountIsBusinessAndTypeIsMissing_thenReturnBadRequestMessage() throws Exception {
		String uri = "/greeting?account=business";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		String expectedErrorDetails = "{\"message\":\"Type parameter is not present\",\"status\":404}";
		assertEquals(expectedErrorDetails, response);
	}

	@Test
	public void whenAccountIsPersonalAndIdIsMissing_thenReturnBadRequestMessage() throws Exception {
		String uri = "/greeting?account=personal";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		String expectedErrorDetails = "{\"message\":\"Id parameter is not present\",\"status\":404}";
		assertEquals(expectedErrorDetails, response);
	}
}