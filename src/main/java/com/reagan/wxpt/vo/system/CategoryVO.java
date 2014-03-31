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
	
	public CategoryVO() {
		category = new SysCategory();
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

}
