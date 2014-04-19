package com.reagan.wxpt.dao.impl.join;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.join.IGroupMenuItemDao;
import com.reagan.wxpt.pojo.join.JoinGroupMenuItem;

@Repository
public class GroupMenuItemDaoImpl extends MapperDaoImpl<JoinGroupMenuItem> implements IGroupMenuItemDao {

	class GroupMenuItemMapper implements RowMapper<JoinGroupMenuItem> {
		
		private ObjectMapperParams<JoinGroupMenuItem> objectMapperParams = null;
		
		public GroupMenuItemMapper(ObjectMapperParams<JoinGroupMenuItem> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public JoinGroupMenuItem mapRow(ResultSet rs, int row) throws SQLException {
			JoinGroupMenuItem object = new JoinGroupMenuItem();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<JoinGroupMenuItem> getRowMapper(
			ObjectMapperParams<JoinGroupMenuItem> objectMapperParams) {
		return new GroupMenuItemMapper(objectMapperParams);
	}

}
