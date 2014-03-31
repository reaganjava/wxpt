package com.reagan.wxpt.vo.system;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessShop;
import com.reagan.wxpt.pojo.system.SysMenuGroup;
import com.reagan.wxpt.pojo.system.SysMenus;
import com.reagan.wxpt.vo.BaseVO;

public class MenuGroupVO extends BaseVO {

	private SysMenuGroup menuGroup;
	
	private List<SysMenuGroup> menuGroupList;
	
	private List<BusinessShop> shopList;
	
	private List<SysMenus> menuList;
	
	public MenuGroupVO() {
		menuGroup = new SysMenuGroup();
		shopList = new ArrayList<BusinessShop>();
		menuList = new ArrayList<SysMenus>();
	}

	public SysMenuGroup getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(SysMenuGroup menuGroup) {
		this.menuGroup = menuGroup;
	}

	public List<BusinessShop> getShopList() {
		return shopList;
	}

	public void setShopList(List<BusinessShop> shopList) {
		this.shopList = shopList;
	}

	public List<SysMenus> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenus> menuList) {
		this.menuList = menuList;
	}

	public List<SysMenuGroup> getMenuGroupList() {
		return menuGroupList;
	}

	public void setMenuGroupList(List<SysMenuGroup> menuGroupList) {
		this.menuGroupList = menuGroupList;
	}
	
}
