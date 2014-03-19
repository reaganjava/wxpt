package com.reagan.wxpt.vo.common;

import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.common.CommonAdmin;

public class AdminVO extends BaseVO {

	private BusinessCompany businessCompany;
	
	private CommonAdmin admin;
	
	private String newPassword;
	
	public AdminVO() {
		admin = new CommonAdmin();
		businessCompany = new BusinessCompany();
	}

	public BusinessCompany getBusinessCompany() {
		return this.businessCompany;
	}

	public void setBusinessCompany(BusinessCompany businessCompany) {
		this.businessCompany = businessCompany;
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
