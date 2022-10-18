package com.ssafy.ws;

import org.aspectj.lang.ProceedingJoinPoint;

public class BookAspect2 {
	public void aaround(ProceedingJoinPoint joinpoint) {
		System.out.println("도서관에 갑니다");
		
		try {
			joinpoint.proceed();
			System.out.println("읽은 것을 정리합니다.");
		} catch (Throwable e) {
			System.out.println("화장실에 갑니다.");
			e.printStackTrace();
		}
		System.out.println("집에 갑니다.");
	}
}
