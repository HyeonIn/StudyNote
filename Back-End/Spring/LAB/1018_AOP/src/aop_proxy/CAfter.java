package aop_proxy;

public class CAfter implements After{
	@Override
	public void doAfter() {
		System.out.println("설거지를 한다.");
	}

}
