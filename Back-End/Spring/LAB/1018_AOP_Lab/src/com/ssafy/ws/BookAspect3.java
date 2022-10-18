package com.ssafy.ws;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect3 {
	@Pointcut("execution(void doSomething())")
	public void ttt() {}
	
	@Before("ttt()")
	public void bbbefore() {
		System.out.println("도서관에 갑니다");
	}
	@After("ttt()")
	public void aaafter() { // throwing이든 returning이든 무조건 핵심관점 끝나면 실행되는 메소드. close같은 작업이 필요
		System.out.println("집에 갑니다.");
	}
	@AfterThrowing("ttt()")
	public void aaafterThrowing() { // 핵심 관점 실행하다 예외발생해서 중단된 경우 하고자 하는 일을 적기.
		// 만약 트랜잭션 처리를 해야하면 여기서는 rollback을 했어야 함.
		System.out.println("화장실에 갑니다.");
	}
	@AfterReturning("ttt()")
	public void aaafterReturning() { // 핵심 관점이 정상적으로 실행완료됨.
		// 만약 트랜잭션 처리를 해야했다면 여기서 commit을 했어야 함.
		System.out.println("읽은 것을 정리합니다.");
	}

}
