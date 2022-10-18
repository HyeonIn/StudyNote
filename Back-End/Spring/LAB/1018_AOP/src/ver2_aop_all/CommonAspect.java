package ver2_aop_all;

//공통 관심사항 구현 클래스
public class CommonAspect {
	public void bbbefore() {
		System.out.println("배가 고프다");
	}
	public void aaafter() {
		System.out.println("설거지를 한다.");
	}
	public void aaafterReturning() {
		System.out.println("음식을 먹는다.");
	}
	public void aaafterThrowing() {
		System.out.println("엄마!!!!");
	}
}
