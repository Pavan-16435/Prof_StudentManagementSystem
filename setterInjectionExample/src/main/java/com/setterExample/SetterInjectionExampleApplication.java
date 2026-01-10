package com.setterExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.setterExample")

public class SetterInjectionExampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SetterInjectionExampleApplication.class);
		
		AudioTypes aud = context.getBean(AudioTypes.class);
		
		aud.data();
	}

}
