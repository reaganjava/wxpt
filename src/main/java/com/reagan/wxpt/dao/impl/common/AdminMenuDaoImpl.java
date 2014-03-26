package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.JDBCDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectParams;
import com.reagan.wxpt.dao.common.IAdminMenuDao;
import com.reagan.wxpt.pojo.common.CommonMenuItem;

public class AdminMenuDaoImpl extends JDBCDaoImpl<CommonMenuItem> implements IAdminMenuDao {
	
	class AdminMenuMapper implements RowMapper<CommonMenuItem> {
		@Override
		public CommonMenuItem mapRow(ResultSet rs, int row) throws SQLException {
			CommonMenuItem menuItem = new CommonMenuItem();
			ObjectParams<CommonMenuItem> objectParams = new ObjectParams<CommonMenuItem>();
			try {
				return objectParams.resultObjectFactory(menuItem, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonMenuItem> getRowMapper() {
		return new AdminMenuMapper();
	}

	
}
