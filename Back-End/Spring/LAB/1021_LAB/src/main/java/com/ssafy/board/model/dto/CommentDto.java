package com.ssafy.board.model.dto;

public class CommentDto {
	private int cno;
	private int bno;
	private String cwriter;
	private String ccontent;
	public CommentDto() {}
	
	public CommentDto(int cno, int bno, String cwriter, String ccontent) {
		this.cno = cno;
		this.bno = bno;
		this.cwriter = cwriter;
		this.ccontent = ccontent;
	}

	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getCwriter() {
		return cwriter;
	}
	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	
}
