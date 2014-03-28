package com.reagan.wxpt.vo.system;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.system.SysRegionCategory;
import com.reagan.wxpt.pojo.business.BusinessShop;
import com.reagan.wxpt.pojo.business.BusinessGoods;
import com.reagan.wxpt.vo.BaseVO;

public class RegionCategoryVO extends BaseVO {

	private SysRegionCategory regionCategory;
	
	private List<SysRegionCategory> regionCategoryList;
	
	private List<BusinessShop> shopList;
	
	private List<BusinessGoods> goodsList;
	
	public RegionCategoryVO() {
		regionCategory = new SysRegionCategory();
		shopList = new ArrayList<BusinessShop>();
		regionCategoryList = new ArrayList<SysRegionCategory>(); 
		goodsList = new ArrayList<BusinessGoods>(); 
	}

	public SysRegionCategory getRegionCategory() {
		return regionCategory;
	}

	public void setRegionCategory(SysRegionCategory regionCategory) {
		this.regionCategory = regionCategory;
	}

	public List<SysRegionCategory> getRegionCategoryList() {
		return regionCategoryList;
	}

	public void setRegionCategoryList(List<SysRegionCategory> regionCategoryList) {
		this.regionCategoryList = regionCategoryList;
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
