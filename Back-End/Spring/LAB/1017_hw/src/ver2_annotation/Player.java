package ver2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Player {
	@Autowired
	private Shoes shoes;
	@Autowired
	private String color;
	@Autowired
	private String name;
	
	public Player(Shoes shoes) {

	}
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
		System.out.println(this.name + " 선수가 득점에 성공합니다!!");
		System.out.println("시그니처인 " + this.color +"색 " + this.shoes.getShoes()+" 축구화가 빛납니다!");
	}
}
