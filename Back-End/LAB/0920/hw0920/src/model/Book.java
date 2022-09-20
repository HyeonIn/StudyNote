package model;

public class Book {
	private int no;
	private String title;
	private int price;
	private String publisher;
	private String writer;
//////////////////////////////////////////////////////////////////////////////////////	
	public Book(int no, String title, int price, String publisher, String writer) {
		this.no = no;
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.writer = writer;
	}
	public Book(String title, int price, String publisher, String writer) {
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.writer = writer;
	}
	public Book() {}
/////////////////////////////////////////////////////////////////////////////////////////
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
///////////////////////////////////////////////////////////////////////////////	
	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", price=" + price + ", publisher=" + publisher + ", writer="
				+ writer + "]";
	}
}
