package com.ssafy.book.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BookDto : 책 한권의 정보", description = "책의 상세 정보를 나타낸다.")
public class BookDto {

	@ApiModelProperty(value = "고유번호", example = "111-111-1111")
	private String isbn;
	@ApiModelProperty(value = "책제목")
	private String title;
	@ApiModelProperty(value = "저자")
	private String author;
	@ApiModelProperty(value = "가격", example = "10000")
	private int price;
	@ApiModelProperty(value = "상세정보")
	private String content;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	@Override
	public String toString() {
		return "BookDto [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", content="
				+ content + "]";
	}

}
