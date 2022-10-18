package com.ssafy.ws;

import org.aspectj.lang.ProceedingJoinPoint;

public class BookAspect {
	public void bbbefore() {
		System.out.println("도서관에 갑니다");
	}
	public void aaafter() {
		System.out.println("집으로 돌아갑니다");
	}
	public void aaafterReturning() {
		System.out.println("읽은 것을 정리합니다.");
	}
	public void aaafterThrowing() {
		System.out.println("화장실에 갑니다.");
	}
	
}
