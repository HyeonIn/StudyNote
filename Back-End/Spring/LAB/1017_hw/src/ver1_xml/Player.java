package ver1_xml;

public class Player {
	private Shoes shoes;
	private String color;
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
		System.out.println(this.name + " 선수가 득점에 성공합니다!!");
		System.out.println("시그니처인 " + this.color +"색 " + this.shoes.getShoes()+" 축구화가 빛납니다!");
	}
}
