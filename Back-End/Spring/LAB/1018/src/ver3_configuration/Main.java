package ver3_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

		Player Son = ctx.getBean(Player.class);

		Son.shoot();

	}

}
