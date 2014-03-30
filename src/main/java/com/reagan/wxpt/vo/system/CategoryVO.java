package com.reagan.wxpt.vo.system;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.system.SysCategory;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.business.BusinessGoods;
import com.reagan.wxpt.pojo.business.BusinessShop;
import com.reagan.wxpt.vo.BaseVO;

public class CategoryVO extends BaseVO {

	private SysCategory category;
	
	private List<BusinessCompany> companyList;
	
	private List<BusinessShop> shopList;
	
	private List<BusinessGoods> goodsList;
	
	public CategoryVO() {
		category = new SysCategory();
		companyList = new ArrayList<BusinessCompany>();
		shopList = new ArrayList<BusinessShop>();
		goodsList= new ArrayList<BusinessGoods>();
	}

	public SysCategory getCategory() {
		return category;
	}

	public void setCategory(SysCategory category) {
		this.category = category;
	}

	public List<BusinessCompany> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<BusinessCompany> companyList) {
		this.companyList = companyList;
	}

	public List<BusinessShop> getShopList() {
		return shopList;
	}

	public void setShopList(List<BusinessShop> shopList) {
		this.shopList = shopList;
	}

	public List<BusinessGoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<BusinessGoods> goodsList) {
		this.goodsList = goodsList;
	}

}
