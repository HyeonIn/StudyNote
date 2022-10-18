package aop_proxy;

public class CBefore implements Before{
	@Override
	public void doBefore() {
		System.out.println("배가 고프다.");
	}

}
