package ver2_aop_all;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ver2_aop_all/beans.xml");
		Boy boy = ctx.getBean(Boy.class);
		boy.makeFood();
		
		Girl girl = (Girl) ctx.getBean("jamin");
		girl.makeFood();
	}
}
