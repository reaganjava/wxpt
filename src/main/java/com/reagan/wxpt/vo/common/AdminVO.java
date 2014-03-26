package com.reagan.wxpt.vo.common;

import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.vo.BaseVO;

public class AdminVO extends BaseVO {

	private BusinessCompany company;
	
	private CommonAdmin admin;
	
	private String newPassword;
	
	public AdminVO() {
		admin = new CommonAdmin();
		company = new BusinessCompany();
	}
	
	public BusinessCompany getCompany() {
		return company;
	}

	public void setCompany(BusinessCompany company) {
		this.company = company;
	}

	public CommonAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(CommonAdmin admin) {
		this.admin = admin;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
