package com.reagan.wxpt.service.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.business.BusinessCompanyContent;
import com.reagan.wxpt.vo.business.CompanyContentVO;

public interface ICompanyContentService {

	void addCompanyContent(CompanyContentVO companyContentVO) throws Exception;

	boolean modifiCompanyContent(CompanyContentVO companyContentVO);

	boolean removeCompanyContent(CompanyContentVO companyContentVO);

	CompanyContentVO viewCompanyContentDetail(CompanyContentVO companyContentVO);

	CompanyContentVO viewCompanyContentList(CompanyContentVO companyContentVO);

	PageBean<BusinessCompanyContent> queryCompanyContentList(
			CompanyContentVO companyContentVO);

}
