package com.yjkj.framework.rbac.book.model;

import java.math.BigDecimal;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.business.model.Business;


public class Book extends BaseModel{
	
	private Integer num;
	private String language;
	private String b_id;
	private BigDecimal price;
	private Business business;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	
	
	
}
