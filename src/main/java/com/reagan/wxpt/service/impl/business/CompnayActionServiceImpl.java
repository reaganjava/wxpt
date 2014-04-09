package com.reagan.wxpt.service.impl.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ICompanyActionDao;
import com.reagan.wxpt.pojo.business.BusinessCompanyAction;
import com.reagan.wxpt.service.business.ICompanyActionService;
import com.reagan.wxpt.vo.business.CompanyActionVO;

public class CompnayActionServiceImpl implements ICompanyActionService {

	private ICompanyActionDao companyActionDao;
	
	public void addCompanyAction(CompanyActionVO companyActionVO) throws Exception {
		companyActionDao.save(companyActionVO.getCompanyAction());
	}
	
	public CompanyActionVO viewCompanyActionDetail(CompanyActionVO companyActionVO) {
		BusinessCompanyAction companyAction = companyActionDao.query(companyActionVO.getCompanyAction());
		companyActionVO.setCompanyAction(companyAction);
		return companyActionVO;
	}
	
	public PageBean<BusinessCompanyAction> queryCompanyActionList(CompanyActionVO companyActionVO) {
		return companyActionDao.queryForPage(companyActionVO.getCompanyAction(), companyActionVO.getPageNO(), companyActionVO.getPageCount());
	}
}
