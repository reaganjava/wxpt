package com.reagan.wxpt.vo.common;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.pojo.common.CommonMenuItem;
import com.reagan.wxpt.pojo.join.JoinGroupMenuItem;
import com.reagan.wxpt.vo.BaseVO;

public class MenuItemVO extends BaseVO {

	private CommonMenuItem menuItem;
	
	private Integer[] groupIds;
	
	private JoinGroupMenuItem groupMenuItem;
	
	private List<CommonMenuItem> menuItemList;
	
	private List<CommonGroup> groupList;
	
	public MenuItemVO() {
		menuItem = new CommonMenuItem();
		groupMenuItem = new JoinGroupMenuItem();
		menuItemList = new ArrayList<CommonMenuItem>();
		groupList = new ArrayList<CommonGroup>();
	}

	public CommonMenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(CommonMenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public List<CommonMenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<CommonMenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public List<CommonGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<CommonGroup> groupList) {
		this.groupList = groupList;
	}

	public JoinGroupMenuItem getGroupMenuItem() {
		return groupMenuItem;
	}

	public void setGroupMenuItem(JoinGroupMenuItem groupMenuItem) {
		this.groupMenuItem = groupMenuItem;
	}

	public Integer[] getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(Integer[] groupIds) {
		this.groupIds = groupIds;
	}
	
}
