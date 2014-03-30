package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.ICountiesDao;
import com.reagan.wxpt.pojo.common.CommonCounties;

@Repository
public class CountiesDaoImpl extends MapperDaoImpl<CommonCounties> implements
		ICountiesDao {

	class CountiesMapper implements RowMapper<CommonCounties> {
		
		private ObjectMapperParams<CommonCounties> objectMapperParams = null;
		
		public CountiesMapper(ObjectMapperParams<CommonCounties> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonCounties mapRow(ResultSet rs, int row) throws SQLException {
			CommonCounties object = new CommonCounties();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonCounties> getRowMapper(
			ObjectMapperParams<CommonCounties> objectMapperParams) {
		return new CountiesMapper(objectMapperParams);
	}


}
