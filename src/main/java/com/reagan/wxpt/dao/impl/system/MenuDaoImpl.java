package com.reagan.wxpt.dao.impl.system;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IMenuDao;
import com.reagan.wxpt.pojo.system.SysMenus;

@Repository
public class MenuDaoImpl extends MapperDaoImpl<SysMenus> implements IMenuDao {

	class MenuMapper implements RowMapper<SysMenus> {
		
		private ObjectMapperParams<SysMenus> objectMapperParams = null;
		
		public MenuMapper(ObjectMapperParams<SysMenus> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public SysMenus mapRow(ResultSet rs, int row) throws SQLException {
			SysMenus object = new SysMenus();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<SysMenus> getRowMapper(
			ObjectMapperParams<SysMenus> objectMapperParams) {
		// TODO Auto-generated method stub
		return new MenuMapper(objectMapperParams);
	}

}
