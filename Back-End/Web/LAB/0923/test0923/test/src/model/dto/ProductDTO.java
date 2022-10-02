package model.dto;

public class ProductDTO {
	private String pcode;
	private String pname;
	private int pquantity;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public ProductDTO() {}
	public ProductDTO(String pcode, String pname, int pquantity) {
		this.pcode = pcode;
		this.pname = pname;
		this.pquantity = pquantity;
	}
	
}
