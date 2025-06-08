package com.yjkj.framework.rbac.business.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.business.model.Business;

public interface BusinessService {

	public Pager informationLoad(Pager pager,Business Business,HttpSession session) throws Exception;
	
	public List<Business> informationLoadAll(Business Business) throws Exception;
	
	public Integer count(Business Business) throws Exception;
	
	public Business informationLoadOne(Business Business) throws Exception;
	
	public void informationDelete(Business Business) throws Exception;
	
	public void informationAdd(Business Business) throws Exception;
	
	public void informationUpade(Business Business) throws Exception;
	
}
