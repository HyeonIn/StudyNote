package ver3_aop_arround;

import java.util.Random;

public class Girl {
	public void makeFood() throws Exception{
		if (new Random().nextBoolean()) {
			throw new Exception("불 났 다!");
		}
		System.out.println("라면을 끓인다"); //핵심 관심사항
	}
}
