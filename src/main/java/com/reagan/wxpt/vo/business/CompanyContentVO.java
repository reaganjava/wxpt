package com.reagan.wxpt.vo.business;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessCompanyContent;
import com.reagan.wxpt.vo.BaseVO;

public class CompanyContentVO extends BaseVO {

	private BusinessCompanyContent companyContent;
	
	private List<BusinessCompanyContent> companyContentList;
	
	public CompanyContentVO() {
		companyContent = new BusinessCompanyContent();
		companyContentList = new ArrayList<BusinessCompanyContent>();
	}

	public BusinessCompanyContent getCompanyContent() {
		return companyContent;
	}

	public void setCompanyContent(BusinessCompanyContent companyContent) {
		this.companyContent = companyContent;
	}

	public List<BusinessCompanyContent> getCompanyContentList() {
		return companyContentList;
	}

	public void setCompanyContentList(
			List<BusinessCompanyContent> companyContentList) {
		this.companyContentList = companyContentList;
	}
	
}
