package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IAdminMenuDao;
import com.reagan.wxpt.pojo.common.CommonMenuItem;

@Repository
public class AdminMenuDaoImpl extends MapperDaoImpl<CommonMenuItem> implements IAdminMenuDao {
	
	class AdminMenuMapper implements RowMapper<CommonMenuItem> {
		
		private ObjectMapperParams<CommonMenuItem> objectMapperParams = null;
		
		public AdminMenuMapper(ObjectMapperParams<CommonMenuItem> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}
		@Override
		public CommonMenuItem mapRow(ResultSet rs, int row) throws SQLException {
			CommonMenuItem menuItem = new CommonMenuItem();
			try {
				return objectMapperParams.resultObjectFactory(menuItem, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonMenuItem> getRowMapper(ObjectMapperParams<CommonMenuItem> objectMapperParams) {
		return new AdminMenuMapper(objectMapperParams);
	}

	
}
