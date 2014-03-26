package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;

import com.reagan.wxpt.dao.common.IAdminDao;
import com.reagan.wxpt.pojo.common.CommonAdmin;


@Repository
public class AdminDaoImpl extends MapperDaoImpl<CommonAdmin> implements IAdminDao {
	
	
	class AdminMapper implements RowMapper<CommonAdmin> {
		
		private ObjectMapperParams<CommonAdmin> objectMapperParams = null;

		public AdminMapper(ObjectMapperParams<CommonAdmin> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommonAdmin admin = new CommonAdmin();
			try {
				return objectMapperParams.resultObjectFactory(admin, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonAdmin> getRowMapper(ObjectMapperParams<CommonAdmin> objectMapperParams) {
		return new AdminMapper(objectMapperParams);
	}


}
