package com.reagan.wxpt.vo.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.reagan.wxpt.pojo.business.BusinessAdvertisement;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.business.BusinessGoods;
import com.reagan.wxpt.pojo.business.BusinessOrderDetail;
import com.reagan.wxpt.pojo.business.BusinessShop;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.pojo.system.SysMenuGroup;
import com.reagan.wxpt.vo.BaseVO;

public class CompanyVO extends BaseVO {
	
	private BusinessCompany company;
	private List<BusinessCompany> companyList;
	private List<CommonAdmin> adminList;
	private List<BusinessGoods> goodList;
	private List<BusinessAdvertisement> advertisementList;
	private List<BusinessOrderDetail> orderDetailList;
	private List<BusinessShop> shopList;
	private List<SysMenuGroup> menuGroupList;
	public BusinessCompany getCompany() {
		return company;
	}
	public void setCompany(BusinessCompany company) {
		this.company = company;
	}
	public List<BusinessCompany> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<BusinessCompany> companyList) {
		this.companyList = companyList;
	}
	public List<CommonAdmin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<CommonAdmin> adminList) {
		this.adminList = adminList;
	}
	public List<BusinessGoods> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<BusinessGoods> goodList) {
		this.goodList = goodList;
	}
	public List<BusinessAdvertisement> getAdvertisementList() {
		return advertisementList;
	}
	public void setAdvertisementList(List<BusinessAdvertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}
	public List<BusinessOrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<BusinessOrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
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
