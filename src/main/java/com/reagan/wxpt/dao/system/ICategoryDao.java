package com.reagan.wxpt.dao.system;

import com.reagan.core.data.dao.IMapperDao;
import com.reagan.wxpt.pojo.system.SysCategory;

public interface ICategoryDao extends IMapperDao<SysCategory>{

	public void updateCategoryContent(int categoryId);
}
