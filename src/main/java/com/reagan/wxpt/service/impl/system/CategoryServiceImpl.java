package com.reagan.wxpt.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ICompanyDao;
import com.reagan.wxpt.dao.business.IGoodsDao;
import com.reagan.wxpt.dao.business.IShopDao;
import com.reagan.wxpt.dao.system.ICategoryDao;
import com.reagan.wxpt.pojo.system.SysCategory;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.pojo.business.BusinessGoods;
import com.reagan.wxpt.pojo.business.BusinessShop;
import com.reagan.wxpt.service.system.ICategoryService;
import com.reagan.wxpt.vo.system.CategoryVO;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private ICompanyDao companyDao;
	
	@Autowired
	private IShopDao shopDao;
	
	@Autowired
	private IGoodsDao goodsDao;
	
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
		boolean isSuccess = false;
		categoryDao.updateCategoryContent(categoryVO.getCategory().getCateid());
		if(isSuccess) {
			int rows = categoryDao.delete(categoryVO.getCategory());	
			if(rows > 0) {
				return true;
			}
		}
		return false;
	} 
	
	@Override
	public CategoryVO viewCategoryDetail(CategoryVO categoryVO) {
		SysCategory category = categoryDao.query(categoryVO.getCategory());
		categoryVO.setCategory(category);
		
		int categoryId = categoryVO.getCategory().getCateid();
		
		BusinessCompany company = new BusinessCompany();
		company.setCategoryId(categoryVO.getCategory().getCateid());
		categoryVO.setCompanyList(companyDao.queryForList(company));
		
		BusinessShop shop = new BusinessShop();
		shop.setCategoryId(categoryId);
		categoryVO.setShopList(shopDao.queryForList(shop));
		
		BusinessGoods goods = new BusinessGoods();
		goods.setCategoryId(categoryId);
		categoryVO.setGoodsList(goodsDao.queryForList(goods));
		
		return categoryVO;
	}
	
	@Override
	public PageBean<SysCategory> queryCategoryList(CategoryVO categoryVO) {
		return categoryDao.queryForPage(categoryVO.getCategory(), categoryVO.getPageNO(), categoryVO.getPageCount());
	}
	
}
