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
	
	private List<SysCategory> categoryList;
	
	private List<BusinessCompany> companyList;
	
	private List<BusinessGoods> goodsList;
	
	private List<BusinessShop> shopList;
	
	public CategoryVO() {
		category = new SysCategory();
		categoryList = new ArrayList<SysCategory>();
		companyList = new ArrayList<BusinessCompany>();
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

	public List<SysCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<SysCategory> categoryList) {
		this.categoryList = categoryList;
	}

	public List<BusinessGoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<BusinessGoods> goodsList) {
		this.goodsList = goodsList;
	}

	public List<BusinessShop> getShopList() {
		return shopList;
	}

	public void setShopList(List<BusinessShop> shopList) {
		this.shopList = shopList;
	}

}
