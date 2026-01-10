package com.beanscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Manager {
	
	public Manager() {
		
		System.out.println("I am in manager constructor");
		
	}
	
	public void work() {
		
		System.out.println("I am doing work ");
		
	}

}
