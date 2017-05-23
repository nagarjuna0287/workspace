package com.spring.Maven_Spring;

import org.springframework.stereotype.Component;

@Component
public class AppleProcessor implements MobileProcessor {

	 public void process(){
		System.out.println("Apple A8 Processor.");
	}
}
