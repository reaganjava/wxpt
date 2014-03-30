package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IPushDao;
import com.reagan.wxpt.pojo.business.BusinessPush;

@Repository
public class PushDaoImpl extends MapperDaoImpl<BusinessPush>
		implements IPushDao {

	class PushMapper implements RowMapper<BusinessPush> {
		
		private ObjectMapperParams<BusinessPush> objectMapperParams = null;
		
		public PushMapper(ObjectMapperParams<BusinessPush> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessPush mapRow(ResultSet rs, int row) throws SQLException {
			BusinessPush object = new BusinessPush();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<BusinessPush> getRowMapper(
			ObjectMapperParams<BusinessPush> objectMapperParams) {
		return new PushMapper(objectMapperParams);
	}

}
