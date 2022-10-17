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
		System.out.println(this.name + " 선수가 선취점을 기록합니다!!");
		System.out.println("그의 트레이드 마크 " + this.color +"색 " + this.shoes.getShoes()+" 축구화가 빛나네요!");
	}
}
