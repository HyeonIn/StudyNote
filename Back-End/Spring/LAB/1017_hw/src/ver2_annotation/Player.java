package ver2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Player {
	@Autowired
	private Shoes shoes;
	@Autowired
	private String color;
	@Autowired
	private String name;
	
//	public Player(Shoes shoes) {
//		this.shoes = shoes;
//	}
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
		System.out.println(this.name + " ������ �������� ����մϴ�!!");
		System.out.println("���� Ʈ���̵� ��ũ " + this.color +"�� " + this.shoes.getShoes()+" �౸ȭ�� �����׿�!");
	}
}
