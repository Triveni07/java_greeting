package com.learning.greeting.service;

import com.learning.greeting.model.Greeting;

public interface GreetingService {
	public abstract Greeting getGreetingMessage(long id, String account, String type) throws RuntimeException;
}
