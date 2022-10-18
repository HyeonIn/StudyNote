package ver2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = 

				new ClassPathXmlApplicationContext("ver2_annotation/beans.xml");

		Player Son = ctx.getBean(Player.class);
		Son.setShoes(ctx.getBean(Shoes.class));
		Son.setColor("노란");
		Son.setName("손흥민");
		Son.shoot();

	}

}
