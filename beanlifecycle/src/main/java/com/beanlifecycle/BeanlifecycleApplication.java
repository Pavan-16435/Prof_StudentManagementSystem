package com.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BeanlifecycleApplication {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Book b = context.getBean(Book.class);
		
		b.service();
		b.destroy();
		
		
	}

}
