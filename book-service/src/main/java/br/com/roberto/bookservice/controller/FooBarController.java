package br.com.roberto.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("book-service")
@Tag(name = "Foo bar endpoint")
public class FooBarController {
	
	private Logger logger = LoggerFactory.getLogger(FooBarController.class); 
	
	
	@GetMapping("/foo-bar")
	@Operation(summary = "Foo bar")
	//@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
	//@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
	//@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public String name() {
		logger.info("Request to foo-bar is received! ");
		//var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		//return response.getBody();
		return "Foo-Bar";
	}
	
	public String fallbackMethod(Exception ex) {
		return "fallbackMethod foo-bar";
	}
	

}
