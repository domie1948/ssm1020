package com.yjkj.framework.rbac.book.service.inte;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.book.model.Book;

public interface BookService {

	public Pager informationLoad(Pager pager,Book Book,HttpSession session) throws Exception;
	
	public List<Book> informationLoadAll(Book Book) throws Exception;
	
	public Integer count(Book Book) throws Exception;
	
	public Book informationLoadOne(Book Book) throws Exception;
	
	public void informationDelete(Book Book) throws Exception;
	
	public void informationAdd(Book Book) throws Exception;
	
	public void informationUpade(Book Book) throws Exception;
	
	public void exceptExcel(Book Book,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception;
	
}
