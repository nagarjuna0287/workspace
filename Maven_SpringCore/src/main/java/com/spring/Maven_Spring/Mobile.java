package com.spring.Maven_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(GetInfo.class);
		Apple a=context.getBean(Apple.class);
		a.details();
	}

}
