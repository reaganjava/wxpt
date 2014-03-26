package com.reagan.wxpt.vo.common;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.pojo.common.CommonMenuItem;
import com.reagan.wxpt.vo.BaseVO;

public class AdminMenuVO extends BaseVO {

	private BusinessCompany company;
	
	private CommonMenuItem menuItem;
	
	private CommonGroup group;
	
	private List<CommonMenuItem> menuItemList;
	
	public AdminMenuVO() {
		group = new CommonGroup();
		company = new BusinessCompany();
		menuItemList = new ArrayList<CommonMenuItem>();
	}

	public BusinessCompany getCompany() {
		return company;
	}

	public void setCompany(BusinessCompany company) {
		this.company = company;
	}

	public CommonMenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(CommonMenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public CommonGroup getGroup() {
		return group;
	}

	public void setGroup(CommonGroup group) {
		this.group = group;
	}

	public List<CommonMenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<CommonMenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	
}
