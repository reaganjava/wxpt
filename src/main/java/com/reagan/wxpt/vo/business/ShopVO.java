package com.reagan.wxpt.vo.business;

import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessShop;
import com.reagan.wxpt.pojo.system.SysMenuGroup;
import com.reagan.wxpt.vo.BaseVO;

public class ShopVO extends BaseVO {
	
	private BusinessShop shop;
	
	private List<BusinessShop> shopList;
	
	private List<SysMenuGroup> menuGroupList;

	public BusinessShop getShop() {
		return shop;
	}

	public void setShop(BusinessShop shop) {
		this.shop = shop;
	}

	public List<BusinessShop> getShopList() {
		return shopList;
	}

	public void setShopList(List<BusinessShop> shopList) {
		this.shopList = shopList;
	}

	public List<SysMenuGroup> getMenuGroupList() {
		return menuGroupList;
	}

	public void setMenuGroupList(List<SysMenuGroup> menuGroupList) {
		this.menuGroupList = menuGroupList;
	}
	
}
