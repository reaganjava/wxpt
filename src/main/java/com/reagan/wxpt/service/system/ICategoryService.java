package com.reagan.wxpt.service.system;

import com.reagan.util.PageBean;
import com.reagan.wxpt.pojo.system.SysCategory;
import com.reagan.wxpt.vo.system.CategoryVO;

public interface ICategoryService {

	void createCategory(CategoryVO categoryVO) throws Exception;

	boolean modifiCategory(CategoryVO categoryVO);

	boolean removeCategory(CategoryVO categoryVO);

	CategoryVO viewCategoryDetail(CategoryVO categoryVO);

	PageBean<SysCategory> queryCategoryList(CategoryVO categoryVO);

}
