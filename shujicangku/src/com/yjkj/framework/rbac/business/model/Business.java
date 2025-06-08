package com.yjkj.framework.rbac.business.model;


import com.yjkj.framework.base.basemodel.BaseModel;


public class Business extends BaseModel{
	
	private String address;
	private String phone;
	private String content;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
