package com.reagan.wxpt.service.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.vo.business.CompanyVO;

public interface ICompanyService {
	
	public void addCompany(CompanyVO companyVO) throws Exception;
	
	public boolean modifiCompany(CompanyVO companyVO);
	
	public boolean removeCompany(CompanyVO companyVO);
	
	public CompanyVO viewCompanyDetail(CompanyVO companyVO);
	
	public PageBean<BusinessCompany> queryCompanyList(CompanyVO companyVO);

	CompanyVO viewCompanyList(CompanyVO companyVO);

}
