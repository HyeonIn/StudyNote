package aop_proxy;

public class CAfterReturning implements AfterReturning{

	@Override
	public void doAfterReturn() {
		System.out.println("음식을 먹는다.");
	}

}
