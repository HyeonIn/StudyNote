package model;


// VO(Variable Object) == DTO(Data Transfer Object) == Bean -> 객체
public class Book {
	private int bno;
	private String title;
	private String writer;
	private String publisher;
	private int price;
//////////////////////////////////////////////////////////////////////////////	
	public Book() {}
	
	public Book(int bno, String title, String writer, String publisher, int price) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
///////////////////////////////////////////////////////////////////////////////////
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Book [bno=" + bno + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher + ", price="
				+ price + "]";
	}
	
}
