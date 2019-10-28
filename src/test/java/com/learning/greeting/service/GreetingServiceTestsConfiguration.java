package com.learning.greeting.service;


import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.learning.greeting.service.GreetingService;

@Profile("test")
@Configuration
public class GreetingServiceTestsConfiguration {
   @Bean
   @Primary
   public GreetingService greetingService() {
      return Mockito.mock(GreetingService.class);
   }
}
