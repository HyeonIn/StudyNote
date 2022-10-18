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
	
	public void bbb () {
		System.out.println("remove!");
	}
	
	public void shoot() {
		System.out.println(this.name + " ������ �������� ����մϴ�!!");
		System.out.println("���� Ʈ���̵� ��ũ " + this.color +"�� " + this.shoes.getShoes()+" �౸ȭ�� �����׿�!");
	}
}
