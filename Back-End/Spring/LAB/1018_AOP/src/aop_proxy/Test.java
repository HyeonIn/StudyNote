package aop_proxy;

public class Test {

	public static void main(String[] args) throws Exception {
		// 핵심 관심사항 구현 객체
		Person boy = new Boy();
		Person girl = new Girl();
		
		// 프록시
		PersonProxy proxy = new PersonProxy();
		
		// 공통관심사항 구현 객체들을 프록시에 조립
		proxy.setBefore(new CBefore()); 
		proxy.setAfter(new CAfter());
		proxy.setAfterReturning(new CAfterReturning());
		proxy.setAfterThrowing(new CAfterThrowing());
		
		// 핵심관심사항 구현 객체 조립
		proxy.setPerson(boy); //boy의 핵심관심사항을 틀에 끼어 넣음
		proxy.lunch(100); 
		
		System.out.println();
		
		// 핵심관심사항 구현 객체 교체
		proxy.setPerson(girl); //girl의 핵심관심사항을 틀에 끼어넣음
		proxy.lunch(100); 
	}
}
