package com.yjkj.framework.rbac.business.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.business.model.Business;
import com.yjkj.framework.rbac.business.service.impl.BusinessServiceImpl;
import com.yjkj.framework.rbac.business.service.inte.BusinessService;

@Controller
@RequestMapping("/business")
public class BusinessController {
	
	@Autowired
	private BusinessService businessService = new BusinessServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Business Business,HttpSession session) {
		try {
		pager = this.businessService.informationLoad(pager,Business,session);
		model.addAttribute("businessList", pager);
		model.addAttribute("business", Business);
		return "jsp/BusinessTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadChoose")
	public String informationLoadChoose(Pager pager,Model model,Business Business,HttpSession session) {
		try {
		pager = this.businessService.informationLoad(pager,Business,session);
		model.addAttribute("businessList", pager);
		model.addAttribute("business", Business);
		return "jsp/BusinessChooseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Business Business,Model model) {
		
		try {
			Business = this.businessService.informationLoadOne(Business);
			model.addAttribute("business", Business);
			return "jsp/Business";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Business Business,Model model) {
		
		try {
			
			this.businessService.informationAdd(Business);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Business Business,Model model) {
		
		try {
			this.businessService.informationDelete(Business);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Business Business,Model model) {
		
		try {
			this.businessService.informationUpade(Business);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
