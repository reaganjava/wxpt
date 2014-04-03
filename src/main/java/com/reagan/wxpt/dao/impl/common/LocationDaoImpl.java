package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.ILocationDao;
import com.reagan.wxpt.pojo.common.CommonLocation;

@Repository
public class LocationDaoImpl extends MapperDaoImpl<CommonLocation> implements
		ILocationDao {

	class LocationMapper implements RowMapper<CommonLocation> {
		
		private ObjectMapperParams<CommonLocation> objectMapperParams = null;
		
		public LocationMapper(ObjectMapperParams<CommonLocation> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonLocation mapRow(ResultSet rs, int row) throws SQLException {
			CommonLocation object = new CommonLocation();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonLocation> getRowMapper(
			ObjectMapperParams<CommonLocation> objectMapperParams) {
		return new FractionMapper(objectMapperParams);
	}


}
