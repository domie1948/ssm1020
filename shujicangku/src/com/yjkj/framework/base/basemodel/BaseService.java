package com.yjkj.framework.base.basemodel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.rbac.book.dao.BookDao;
import com.yjkj.framework.rbac.business.dao.BusinessDao;
import com.yjkj.framework.rbac.factory.dao.FactoryDao;
import com.yjkj.framework.rbac.typee.dao.TypeeDao;
@Service
public class BaseService {
	
	
	
	@Autowired
	public TypeeDao typeeDao;
	
	@Autowired
	public BookDao bookDao;
	
	@Autowired
	public BusinessDao businessDao;
	
	@Autowired
	public FactoryDao factoryDao;
	

}
