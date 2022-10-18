package ver3_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Player {
	@Autowired
	private Shoes shoes;
	
	@Autowired
	@Value("손흥민")
	private String name;
	
	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void shoot() {
		System.out.println(this.name);
		System.out.println(this.shoes.getShoes()+" 축구화가 빛난다");
	}
}
