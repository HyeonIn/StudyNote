package model.dto;

public class UserDTO {
	private String mid;
	private String mpass;
	private String mname;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public UserDTO() {}
	public UserDTO(String mid, String mpass, String mname) {
		this.mid = mid;
		this.mpass = mpass;
		this.mname = mname;
	}
}
