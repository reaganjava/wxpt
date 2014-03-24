package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.JDBCDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectParams;

import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.pojo.common.CommonAdmin;


@Repository
public class AdminDaoImpl extends JDBCDaoImpl<CommonAdmin> implements IAdminDao {
	
	
	class AdminMapper implements RowMapper<CommonAdmin> {

		@Override
		public CommonAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommonAdmin admin = new CommonAdmin();
			ObjectParams<CommonAdmin> objectParams = new ObjectParams<CommonAdmin>();
			try {
				return objectParams.resultObjectFactory(admin, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonAdmin> getRowMapper() {
		return new AdminMapper();
	}


}
