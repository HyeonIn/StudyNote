package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BookTest {
	public static void main(String[] args) throws RestroomException{
		ApplicationContext context = new FileSystemXmlApplicationContext("resources/applicationContext3.xml");
		Person r1 = context.getBean(Person.class);
		
		r1.doSomething();
		
	}	
}
