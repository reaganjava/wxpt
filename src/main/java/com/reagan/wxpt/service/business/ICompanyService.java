package com.reagan.wxpt.service.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.vo.common.CompanyVO;

public interface ICompanyService {
	
	public void addCompany(CompanyVO companyVO) throws Exception;
	
	public int modifiCompany(CompanyVO companyVO);
	
	public int removeCompany(CompanyVO companyVO);
	
	public CompanyVO viewCompanyDetail(CompanyVO companyVO);
	
	public PageBean<BusinessCompany> queryCompanyList(CompanyVO companyVO);

}
