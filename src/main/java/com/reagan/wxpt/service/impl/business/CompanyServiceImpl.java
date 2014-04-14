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
	public boolean modifiCompany(CompanyVO companyVO) {
		int rows = companyDao.update(companyVO.getCompany());
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeCompany(CompanyVO companyVO) {
		int rows = companyDao.delete(companyVO.getCompany());
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public CompanyVO viewCompanyDetail(CompanyVO companyVO) {
		BusinessCompany company = companyDao.query(companyVO.getCompany());
		companyVO.setCompany(company);
		return companyVO;
	}

	@Override
	public PageBean<BusinessCompany> queryCompanyList(CompanyVO companyVO) {
		return companyDao.queryForPage(companyVO.getCompany(), companyVO.getPageNO(), companyVO.getPageRows());
	}
	
}
