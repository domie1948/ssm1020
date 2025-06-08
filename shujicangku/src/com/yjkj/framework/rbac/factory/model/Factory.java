package com.yjkj.framework.rbac.factory.model;


import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.book.model.Book;


public class Factory extends BaseModel{
	
	private String book_id;
	private Integer num;
	private String typee;
	private Book book;
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTypee() {
		return typee;
	}
	public void setTypee(String typee) {
		this.typee = typee;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
