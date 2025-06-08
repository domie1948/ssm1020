package com.yjkj.framework.rbac.factory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.book.model.Book;
import com.yjkj.framework.rbac.factory.model.Factory;
import com.yjkj.framework.rbac.factory.service.inte.FactoryService;
@Service
public class FactoryServiceImpl extends BaseService implements FactoryService {

	
	@Override
	public Pager informationLoad(Pager pager,Factory Factory,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("factory", Factory);
		List<Factory> list = this.factoryDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Factory));
		return pager;
	}

	@Override
	public List<Factory> informationLoadAll(Factory Factory) throws Exception {
		List<Factory> list = this.factoryDao.informationLoadAll(Factory);
		return list;
	}
	

	@Override
	public Integer count(Factory Factory) throws Exception {
		Integer count = this.factoryDao.count(Factory);
		return count;
	}

	@Override
	public Factory informationLoadOne(Factory Factory) throws Exception {
			Factory = this.factoryDao.informationLoadOne(Factory);
		return Factory;
	}

	@Override
	public void informationDelete(Factory Factory) throws Exception {
			this.factoryDao.informationDelete(Factory);

	}

	@Override
	public void informationAdd(Factory Factory) throws Exception {
			Factory.setId(Regular.createId());
			Factory.setCreatetime(CreatDate.getDate());
			Book book = new Book();
			book.setId(Factory.getBook_id());
			book = this.bookDao.informationLoadOne(book);
			if(Factory.getTypee().equals("1")) {
				book.setNum(book.getNum()+Factory.getNum());
			}
			if(Factory.getTypee().equals("2")) {
				if(book.getNum()<Factory.getNum()) {
					throw new RuntimeException("书籍数量不足");
				}
				book.setNum(book.getNum()-Factory.getNum());
			}
			this.bookDao.informationUpdate(book);
			this.factoryDao.informationAdd(Factory);

	}

	@Override
	public void informationUpade(Factory Factory) throws Exception {
			this.factoryDao.informationUpdate(Factory);
	}

}
