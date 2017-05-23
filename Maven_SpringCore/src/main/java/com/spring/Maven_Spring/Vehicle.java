package com.spring.Maven_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  Vehicle{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
       VehicleAction v=(VehicleAction)context.getBean("vehicle");
       v.drive();
       
    }
}
