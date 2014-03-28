package com.reagan.wxpt.dao.impl.system;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IMenuDao;
import com.reagan.wxpt.pojo.system.SysMenus;

public class MenuDaoImpl extends MapperDaoImpl<SysMenus> implements IMenuDao {

	
	@Override
	public RowMapper<SysMenus> getRowMapper(
			ObjectMapperParams<SysMenus> objectMapperParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
