package com.reagan.wxpt.service.impl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ICompanyDao;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.service.business.ICompanyService;
import com.reagan.wxpt.vo.business.CompanyVO;

@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	@Override
	public void addCompany(CompanyVO companyVO) throws Exception {
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
	public CompanyVO viewCompanyDetail(CompanyVO companyVO) {
		BusinessCompany company = companyDao.query(companyVO.getCompany());
		companyVO.setCompany(company);
		return companyVO;
	}

	@Override
	public PageBean<BusinessCompany> queryCompanyList(CompanyVO companyVO) {
		return companyDao.queryForPage(companyVO.getCompany(), companyVO.getPageNO(), companyVO.getPageCount());
	}
	
}
