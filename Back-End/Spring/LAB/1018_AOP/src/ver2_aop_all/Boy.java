package ver2_aop_all;

import java.util.Random;

public class Boy {
	public void makeFood() throws Exception {
		if (new Random().nextBoolean()) {
			throw new Exception("불 났 다!");
		}
		System.out.println("치킨을 만든다"); //핵심 관심사항
	}
}
