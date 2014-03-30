package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IFractionDao;
import com.reagan.wxpt.pojo.common.CommonFraction;

@Repository
public class FractionDaoImpl extends MapperDaoImpl<CommonFraction> implements
		IFractionDao {

	class FractionMapper implements RowMapper<CommonFraction> {
		
		private ObjectMapperParams<CommonFraction> objectMapperParams = null;
		
		public FractionMapper(ObjectMapperParams<CommonFraction> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonFraction mapRow(ResultSet rs, int row) throws SQLException {
			CommonFraction object = new CommonFraction();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonFraction> getRowMapper(
			ObjectMapperParams<CommonFraction> objectMapperParams) {
		return new FractionMapper(objectMapperParams);
	}


}
