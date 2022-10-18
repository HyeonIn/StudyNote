package aop_proxy;

public class CAfterThrowing implements AfterThrowing {
	@Override
	public void doAfterThrow() {
		System.out.println("엄마를 부른다!!!");
	}
}
