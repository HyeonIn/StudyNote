package ver2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = 

				new ClassPathXmlApplicationContext("ver2_annotation/beans.xml");

		Player Son = ctx.getBean(Player.class);

		Son.shoot();

	}

}
