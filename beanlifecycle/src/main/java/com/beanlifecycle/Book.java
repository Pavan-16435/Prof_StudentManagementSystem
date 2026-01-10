package com.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Book {
	
	
	public Book() {
		
		System.out.println("Constructor has been called");
		
	}

	@PostConstruct
	public void initialize() {
		
		System.out.println("Initialize method is called");
		
	}
	
	
	public void service() {
		
		System.out.println("Service method is called");
		
	}
	
	@PreDestroy
	public void destroy() {
		
		System.out.println("Destroy method is called");
		
	}
}
