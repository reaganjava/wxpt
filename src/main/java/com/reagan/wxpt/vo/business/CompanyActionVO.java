package com.reagan.wxpt.vo.business;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessCompanyAction;
import com.reagan.wxpt.vo.BaseVO;

public class CompanyActionVO extends BaseVO {

	private BusinessCompanyAction companyAction;
	
	private List<BusinessCompanyAction> companyActionList;
	
	public CompanyActionVO() {
		companyAction = new BusinessCompanyAction();
		companyActionList = new ArrayList<BusinessCompanyAction>();
	}

	public BusinessCompanyAction getCompanyAction() {
		return companyAction;
	}

	public void setCompanyAction(BusinessCompanyAction companyAction) {
		this.companyAction = companyAction;
	}

	public List<BusinessCompanyAction> getCompanyActionList() {
		return companyActionList;
	}

	public void setCompanyActionList(List<BusinessCompanyAction> companyActionList) {
		this.companyActionList = companyActionList;
	}
	
}
