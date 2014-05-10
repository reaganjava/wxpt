package com.reagan.wxpt.service.impl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ICompanyContentDao;
import com.reagan.wxpt.pojo.business.BusinessCompanyContent;
import com.reagan.wxpt.service.business.ICompanyContentService;
import com.reagan.wxpt.vo.business.CompanyContentVO;

@Service("companyContentService")
public class CompanyContentServiceImpl implements ICompanyContentService {

	@Autowired
	private ICompanyContentDao companyContentDao;
	
	@Override
	public void addCompanyContent(CompanyContentVO companyContentVO) throws Exception {
		companyContentDao.save(companyContentVO.getCompanyContent());
	}
	
	
	@Override
	public boolean modifiCompanyContent(CompanyContentVO companyContentVO) {
		int rows = companyContentDao.update(companyContentVO.getCompanyContent());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeCompanyContent(CompanyContentVO companyContentVO) {
		int rows = companyContentDao.delete(companyContentVO.getCompanyContent());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public CompanyContentVO viewCompanyContentDetail(CompanyContentVO companyContentVO) {
		BusinessCompanyContent companyContent = companyContentDao.query(companyContentVO.getCompanyContent());
		companyContentVO.setCompanyContent(companyContent);
		return companyContentVO;
	}
	
	@Override
	public CompanyContentVO viewCompanyContentList(CompanyContentVO companyContentVO) {
		List<BusinessCompanyContent> companyContentList = companyContentDao.queryForList(companyContentVO.getCompanyContent());
		companyContentVO.setCompanyContentList(companyContentList);
		return companyContentVO;
	} 
	
	@Override
	public PageBean<BusinessCompanyContent> queryCompanyContentList(CompanyContentVO companyContentVO) {
		return companyContentDao.queryForPage(companyContentVO.getCompanyContent(), companyContentVO.getPageNO(), companyContentVO.getPageRows());
	}
}
