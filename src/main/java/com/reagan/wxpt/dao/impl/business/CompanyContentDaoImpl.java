package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.ICompanyContentDao;
import com.reagan.wxpt.pojo.business.BusinessCompanyContent;

@Repository
public class CompanyContentDaoImpl extends
		MapperDaoImpl<BusinessCompanyContent> implements ICompanyContentDao {

	class CompanyContentMapper implements RowMapper<BusinessCompanyContent> {
		
		private ObjectMapperParams<BusinessCompanyContent> objectMapperParams = null;
		
		public CompanyContentMapper(ObjectMapperParams<BusinessCompanyContent> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessCompanyContent mapRow(ResultSet rs, int row) throws SQLException {
			BusinessCompanyContent object = new BusinessCompanyContent();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<BusinessCompanyContent> getRowMapper(
			ObjectMapperParams<BusinessCompanyContent> objectMapperParams) {
		return new CompanyContentMapper(objectMapperParams);
	}

}
