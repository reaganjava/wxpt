package com.reagan.wxpt.dao.impl.system;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.ICategoryDao;
import com.reagan.wxpt.pojo.system.SysCategory;

public class CategoryDaoImpl extends MapperDaoImpl<SysCategory> implements
		ICategoryDao {

	@Override
	public RowMapper<SysCategory> getRowMapper(
			ObjectMapperParams<SysCategory> objectMapperParams) {
		return null;
	}


}
