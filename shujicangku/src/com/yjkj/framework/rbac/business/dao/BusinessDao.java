package com.yjkj.framework.rbac.business.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.business.model.Business;

public interface BusinessDao {

	public List<Business> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Business> informationLoadAll(Business Business) throws Exception;
	
	public Integer count(Business Business) throws Exception;
	
	public Business informationLoadOne(Business Business) throws Exception;
	
	public void informationDelete(Business Business) throws Exception;
	
	public void informationAdd(Business Business) throws Exception;
	
	public void informationUpdate(Business Business) throws Exception;
	
}
