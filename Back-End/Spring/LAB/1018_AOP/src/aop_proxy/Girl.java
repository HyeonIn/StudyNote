package aop_proxy;

import java.util.Random;

public class Girl implements Person {
	@Override
	public String lunch(int arg) throws Exception {
		/////////////////////////////////////////////
		// 핵심관심사항
		System.out.println("갈비를 만든다."+arg);
		if (new Random().nextBoolean()) {
			throw new Exception("고기가 없다!!");
		}
		//////////////////////////////////////////////
		return "갈비가 적당히 구워졌다.";
	}

}
