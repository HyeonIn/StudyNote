package ver3_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스는 new Beans() 하는 용도가 아님. 객체 저장 창고임
@ComponentScan("ver3_configuration")
public class Beans {
//	@Bean
//	public Player son() {
//		Player p = new Player();
//		p.setShoes(nikeShoes());
//		return p;
//	}
//	
//	@Bean
//	public Shoes nikeShoes() {
//		return new NikeShoes();
//	}
//	
//	@Bean
//	public Shoes adidasShoes() {
//		return new AdidasShoes();
//	}
}
