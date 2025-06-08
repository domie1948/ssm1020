package com.yjkj.framework.rbac.book.web;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.book.model.Book;
import com.yjkj.framework.rbac.book.service.impl.BookServiceImpl;
import com.yjkj.framework.rbac.book.service.inte.BookService;
import com.yjkj.framework.rbac.business.service.impl.BusinessServiceImpl;
import com.yjkj.framework.rbac.business.service.inte.BusinessService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService = new BookServiceImpl();
	
	@Autowired
	private BusinessService businessService = new BusinessServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Book Book,HttpSession session) {
		try {
		pager = this.bookService.informationLoad(pager,Book,session);
		model.addAttribute("bookList", pager);
		model.addAttribute("book", Book);
		return "jsp/BookTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadChoose")
	public String informationLoadChoose(Pager pager,Model model,Book Book,HttpSession session) {
		try {
		pager = this.bookService.informationLoad(pager,Book,session);
		model.addAttribute("bookList", pager);
		model.addAttribute("book", Book);
		return "jsp/BookChooseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Book Book,Model model) {
		
		try {
			Book = this.bookService.informationLoadOne(Book);
			model.addAttribute("businessList", this.businessService.informationLoadAll(null));
			model.addAttribute("book", Book);
			return "jsp/Book";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Book Book,Model model) {
		
		try {
			
			this.bookService.informationAdd(Book);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Book Book,Model model) {
		
		try {
			this.bookService.informationDelete(Book);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Book Book,Model model) {
		
		try {
			this.bookService.informationUpade(Book);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/exportExcel")
	public String exportExcel(Book Book,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		try {
			this.bookService.exceptExcel(Book, request, response, session);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
