package com.reagan.wxpt.vo.common;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.pojo.common.CommonMenuItem;
import com.reagan.wxpt.vo.BaseVO;

public class AdminVO extends BaseVO {

	private BusinessCompany company;
	
	private CommonGroup group;
	
	private CommonAdmin admin;
	
	private List<CommonAdmin> adminList;
	
	private List<CommonMenuItem> menuItemList;
	
	private String newPassword;
	
	public AdminVO() {
		admin = new CommonAdmin();
		group = new CommonGroup();
		company = new BusinessCompany();
		adminList = new ArrayList<CommonAdmin>();
		menuItemList = new ArrayList<CommonMenuItem>();
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

	public CommonGroup getGroup() {
		return group;
	}

	public void setGroup(CommonGroup group) {
		this.group = group;
	}

	public List<CommonAdmin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<CommonAdmin> adminList) {
		this.adminList = adminList;
	}

	public List<CommonMenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<CommonMenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
