package com.reagan.wxpt.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ICompanyDao;
import com.reagan.wxpt.dao.join.ICompanyCategoryDao;
import com.reagan.wxpt.dao.system.ICategoryDao;
import com.reagan.wxpt.pojo.system.SysCategory;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.join.JoinCompanyCategory;
import com.reagan.wxpt.service.system.ICategoryService;
import com.reagan.wxpt.vo.system.CategoryVO;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private ICompanyDao companyDao;
	
	@Autowired
	private ICompanyCategoryDao companyCateogryDao;
	
	
	@Override
	public void createCategory(CategoryVO categoryVO) throws Exception {
		categoryDao.save(categoryVO.getCategory());
	}
	
	@Override
	public boolean modifiCategory(CategoryVO categoryVO) {
		int rows = categoryDao.update(categoryVO.getCategory());
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeCategory(CategoryVO categoryVO) {
		JoinCompanyCategory companyCategory = new JoinCompanyCategory();
		companyCategory.setCategoryId(categoryVO.getCategory().getCategoryId());
		companyCateogryDao.delete(companyCategory);
		int rows = categoryDao.delete(categoryVO.getCategory());	
		if(rows > 0) {
			return true;
		}
		return false;
	} 
	
	@Override
	public CategoryVO viewCategoryDetail(CategoryVO categoryVO) {
		SysCategory category = categoryDao.query(categoryVO.getCategory());
		categoryVO.setCategory(category);
		
		BusinessCompany company = new BusinessCompany();
		company.setCategoryId(categoryVO.getCategory().getCateid());
		categoryVO.setCompanyList(companyDao.queryForList(company));
		
		return categoryVO;
	}
	
	@Override
	public PageBean<SysCategory> queryCategoryList(CategoryVO categoryVO) {
		return categoryDao.queryForPage(categoryVO.getCategory(), categoryVO.getPageNO(), categoryVO.getPageCount());
	}
	
}
