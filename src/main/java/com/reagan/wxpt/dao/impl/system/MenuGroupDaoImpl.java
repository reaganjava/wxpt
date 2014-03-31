package com.reagan.wxpt.dao.impl.system;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IMenuGroupDao;
import com.reagan.wxpt.pojo.system.SysMenuGroup;

public class MenuGroupDaoImpl extends MapperDaoImpl<SysMenuGroup> implements
		IMenuGroupDao {

	class MenuGroupMapper implements RowMapper<SysMenuGroup> {
		
		private ObjectMapperParams<SysMenuGroup> objectMapperParams = null;
		
		public MenuGroupMapper(ObjectMapperParams<SysMenuGroup> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public SysMenuGroup mapRow(ResultSet rs, int row) throws SQLException {
			SysMenuGroup object = new SysMenuGroup();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<SysMenuGroup> getRowMapper(
			ObjectMapperParams<SysMenuGroup> objectMapperParams) {
		// TODO Auto-generated method stub
		return new MenuGroupMapper(objectMapperParams);
	}

}
