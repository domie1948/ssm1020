package com.yjkj.framework.rbac.factory.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.factory.model.Factory;
import com.yjkj.framework.rbac.factory.service.impl.FactoryServiceImpl;
import com.yjkj.framework.rbac.factory.service.inte.FactoryService;

@Controller
@RequestMapping("/factory")
public class FactoryController {
	
	@Autowired
	private FactoryService factoryService = new FactoryServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Factory Factory,HttpSession session) {
		try {
		pager = this.factoryService.informationLoad(pager,Factory,session);
		model.addAttribute("factoryList", pager);
		model.addAttribute("factory", Factory);
		return "jsp/FactoryTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadChoose")
	public String informationLoadChoose(Pager pager,Model model,Factory Factory,HttpSession session) {
		try {
		pager = this.factoryService.informationLoad(pager,Factory,session);
		model.addAttribute("factoryList", pager);
		model.addAttribute("factory", Factory);
		return "jsp/FactoryChooseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Factory Factory,Model model) {
		
		try {
			Factory = this.factoryService.informationLoadOne(Factory);
			model.addAttribute("factory", Factory);
			return "jsp/Factory";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Factory Factory,Model model) {
		
		try {
			
			this.factoryService.informationAdd(Factory);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Factory Factory,Model model) {
		
		try {
			this.factoryService.informationDelete(Factory);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Factory Factory,Model model) {
		
		try {
			this.factoryService.informationUpade(Factory);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
