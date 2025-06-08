package com.yjkj.framework.rbac.web;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.rbac.business.service.impl.BusinessServiceImpl;
import com.yjkj.framework.rbac.business.service.inte.BusinessService;
import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;



@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();

	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	@Autowired
	private BusinessService businessService = new BusinessServiceImpl();
	
	
	
	
	

	
	@RequestMapping("/login")
	public String login() {
		return "jsp/Login";
	}
	
	@RequestMapping("/index")
	public String index() {
		
		return "jsp/index";
		
	}
	
	@RequestMapping("/sign")
	public String sign() {
		
		return "jsp/Sign";
		
	}
	
	@RequestMapping("/main")
	public String main() {
		
		return "jsp/Main";
		
	}
	
	@RequestMapping("/left")
	public String left(Model model) {
		
		return "jsp/Left";
		
	}
	
	@RequestMapping("/top")
	public String top() {
		
		return "jsp/Top";
		
	}
	
	@RequestMapping("/passUpdate")
	public String passUpdate() {
		
		return "jsp/PassUpdate";
		
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(Model model){
		try{
		List<RoleInfo> list = this.ris.query();
		model.addAttribute("role", list);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserAdd";
	}
	
	@RequestMapping("/functionAdd")
	public String functionAdd(){
		return "jsp/FunctionAdd";
	}
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model){
		model.addAttribute("function", this.fs.query());
		return "jsp/RoleAdd";
	}
	
	
	@RequestMapping("/bookAdd")
	public String bookAdd(Model model){
		try {
			model.addAttribute("businessList", this.businessService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/BookAdd";
	}
	
	@RequestMapping("/businessAdd")
	public String businessAdd(){
		return "jsp/BusinessAdd";
	}
	
	@RequestMapping("/factoryAdd")
	public String factoryAdd(Model model,String book_id,String typee){
		model.addAttribute("typee", typee);
		model.addAttribute("book_id", book_id);
		return "jsp/FactoryAdd";
	}
	
	
	
	
	
	
	
	
}
