package ver1;

import java.util.Random;

public class Girl{
	public void makeFood() {
		System.out.println("배가 고프다"); // before advice
		try {
			if (new Random().nextBoolean()) {
				throw new Exception("불 났 다!");
			}
			System.out.println("라면을 끓인다"); //핵심 관심사항
			System.out.println("음식을 먹는다"); // after returning advice
		}catch (Exception e) {
			System.out.println("엄마!!!!!"); //after throwing advice
		}finally {
			System.out.println("설거지를 한다");
		}
	}
}
