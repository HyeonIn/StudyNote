package ver2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Player {
	@Autowired
	private Shoes shoes;
	@Autowired(required = false)
	private String color;
	@Autowired
	private String name;
	
	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void shoot() {
		System.out.println(this.name);
		System.out.println(this.color +"색 " + this.shoes.getShoes()+" 축구화가 빛난다");
	}
}
