package com.yjkj.framework.rbac.book.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.book.model.Book;

public interface BookDao {

	public List<Book> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Book> informationLoadAll(Book Book) throws Exception;
	
	public Integer count(Book Book) throws Exception;
	
	public Book informationLoadOne(Book Book) throws Exception;
	
	public void informationDelete(Book Book) throws Exception;
	
	public void informationAdd(Book Book) throws Exception;
	
	public void informationUpdate(Book Book) throws Exception;
	
}
