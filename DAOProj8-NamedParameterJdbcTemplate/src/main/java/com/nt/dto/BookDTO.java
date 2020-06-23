package com.nt.dto;

import java.io.Serializable;

public class BookDTO implements Serializable{
	private int bookId;
	private String bookName;
	private String author;
	private float price;
	private String publisher;
	private String status;
	private String category;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "BookStoreDTO [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", publisher=" + publisher + ", status=" + status + ", category=" + category + "]";
	}
	
	
	

}
