package com.yjkj.framework.rbac.factory.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.factory.model.Factory;

public interface FactoryDao {

	public List<Factory> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Factory> informationLoadAll(Factory Factory) throws Exception;
	
	public Integer count(Factory Factory) throws Exception;
	
	public Factory informationLoadOne(Factory Factory) throws Exception;
	
	public void informationDelete(Factory Factory) throws Exception;
	
	public void informationAdd(Factory Factory) throws Exception;
	
	public void informationUpdate(Factory Factory) throws Exception;
	
}
