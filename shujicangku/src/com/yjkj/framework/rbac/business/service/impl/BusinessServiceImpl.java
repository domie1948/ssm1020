package com.yjkj.framework.rbac.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.business.model.Business;
import com.yjkj.framework.rbac.business.service.inte.BusinessService;
@Service
public class BusinessServiceImpl extends BaseService implements BusinessService {

	
	@Override
	public Pager informationLoad(Pager pager,Business Business,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("business", Business);
		List<Business> list = this.businessDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Business));
		return pager;
	}

	@Override
	public List<Business> informationLoadAll(Business Business) throws Exception {
		List<Business> list = this.businessDao.informationLoadAll(Business);
		return list;
	}
	

	@Override
	public Integer count(Business Business) throws Exception {
		Integer count = this.businessDao.count(Business);
		return count;
	}

	@Override
	public Business informationLoadOne(Business Business) throws Exception {
			Business = this.businessDao.informationLoadOne(Business);
		return Business;
	}

	@Override
	public void informationDelete(Business Business) throws Exception {
			this.businessDao.informationDelete(Business);

	}

	@Override
	public void informationAdd(Business Business) throws Exception {
			Business.setId(Regular.createId());
			Business.setCreatetime(CreatDate.getDate());
			this.businessDao.informationAdd(Business);

	}

	@Override
	public void informationUpade(Business Business) throws Exception {
			this.businessDao.informationUpdate(Business);
	}

}
