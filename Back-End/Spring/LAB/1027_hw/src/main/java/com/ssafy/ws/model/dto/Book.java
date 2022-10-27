package com.ssafy.ws.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class Book {
	private String isbn;
	private String author;
	private String title;
	private int price;
	private String content;
	// 중복 파일을 방지하기 위해 img에 prefix를 추가한 이름
	private String img;

	public Book() {
	}

	public Book(String isbn, String author, String title, int price, String content, String img) {
		this(isbn, author, title, price, content, img, null);
	}

	public Book(String isbn, String author, String title, int price, String content, String img, MultipartFile file) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
		this.content = content;
		this.img = img;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
