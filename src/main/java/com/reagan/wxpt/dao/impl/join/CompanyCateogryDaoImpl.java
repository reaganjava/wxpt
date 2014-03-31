package com.reagan.wxpt.dao.impl.join;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.join.ICompanyCategoryDao;
import com.reagan.wxpt.pojo.join.JoinCompanyCategory;

public class CompanyCateogryDaoImpl extends MapperDaoImpl<JoinCompanyCategory>
		implements ICompanyCategoryDao {

	class CompanyCateogryMapper implements RowMapper<JoinCompanyCategory> {
		
		private ObjectMapperParams<JoinCompanyCategory> objectMapperParams = null;
		
		public CompanyCateogryMapper(ObjectMapperParams<JoinCompanyCategory> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public JoinCompanyCategory mapRow(ResultSet rs, int row) throws SQLException {
			JoinCompanyCategory object = new JoinCompanyCategory();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<JoinCompanyCategory> getRowMapper(
			ObjectMapperParams<JoinCompanyCategory> objectMapperParams) {
	
		return new CompanyCateogryMapper(objectMapperParams);
	}

}
