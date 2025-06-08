package com.yjkj.framework.rbac.factory.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.factory.model.Factory;

public interface FactoryService {

	public Pager informationLoad(Pager pager,Factory Factory,HttpSession session) throws Exception;
	
	public List<Factory> informationLoadAll(Factory Factory) throws Exception;
	
	public Integer count(Factory Factory) throws Exception;
	
	public Factory informationLoadOne(Factory Factory) throws Exception;
	
	public void informationDelete(Factory Factory) throws Exception;
	
	public void informationAdd(Factory Factory) throws Exception;
	
	public void informationUpade(Factory Factory) throws Exception;
	
}
