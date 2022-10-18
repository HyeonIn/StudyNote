package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) throws ApplicationException {
		ApplicationContext context = new FileSystemXmlApplicationContext("resources/applicationContext.xml");
		System.out.println("******1. GeneralUser");
		User gu = context.getBean("generalUser", User.class);
		gu.useApp();
		System.out.println("******2. AdminUser");
		User au = context.getBean("adminUser", User.class);
		au.useApp();
	}

}
