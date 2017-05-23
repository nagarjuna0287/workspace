package com.spring.Maven_Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
//@ComponentScan(basePackages="com.spring.Maven_Spring")
@Component
public class GetInfo {
	@Bean
	public Apple getPhoneCongfig(){
		return new Apple();
	}
	@Bean
	public AppleProcessor getprocessor(){
		return new AppleProcessor();
	}
}
