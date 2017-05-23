package com.spring.Maven_Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Apple {
	@Autowired
	MobileProcessor cpu;

	
	public void details(){
		
		System.out.println("iphone7,128gb,12mp ");
		cpu.process();
	}
}
