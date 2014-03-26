package com.reagan.wxpt.service.impl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ICompanyDao;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.service.business.ICompanyService;
import com.reagan.wxpt.vo.common.CompanyVO;

@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	@Override
	public void addCompany(CompanyVO companyVO) {
		companyDao.save(companyVO.getCompany());
	}

	@Override
	public int modifiCompany(CompanyVO companyVO) {
		return companyDao.update(companyVO.getCompany());
	}

	@Override
	public int removeCompany(CompanyVO companyVO) {
		return companyDao.delete(companyVO.getCompany());
	}

	@Override
	public CompanyVO viewCompanyDetail(CompanyVO compnayVO) {
		BusinessCompany company = companyDao.query(compnayVO.getCompany());
		compnayVO.setCompany(company);
		return compnayVO;
	}

	@Override
	public PageBean<BusinessCompany> queryCompanyList(CompanyVO compnayVO) {
		return companyDao.queryForPage(compnayVO.getCompany(), compnayVO.getPageNO(), compnayVO.getPageCount());
	}
	
}
