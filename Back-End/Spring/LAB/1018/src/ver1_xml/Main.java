package ver1_xml;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = 

				new ClassPathXmlApplicationContext("ver1_xml/beans.xml");

		Player Son = ctx.getBean(Player.class);
		
		((ClassPathXmlApplicationContext)ctx).close();
		Son.shoot();

	}

}
