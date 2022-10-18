package ver3_aop_arround;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 관심사항 구현 클래스
public class CommonAspect {
	public void aaround(ProceedingJoinPoint joinpoint) {
		System.out.println("배가 고프다");
		
		try {
			joinpoint.proceed();
			System.out.println("음식을 먹는다.");
		} catch (Throwable e) {
			System.out.println("엄마!!!!");
			e.printStackTrace();
		}
		System.out.println("설거지를 한다.");
	}
}
