package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.ICompanyDao;
import com.reagan.wxpt.pojo.business.BusinessCompany;

@Repository
public class CompanyDaoImpl extends MapperDaoImpl<BusinessCompany> implements ICompanyDao {

	class CompanyMapper implements RowMapper<BusinessCompany> {
		
		private ObjectMapperParams<BusinessCompany> objectMapperParams = null;
		
		public CompanyMapper(ObjectMapperParams<BusinessCompany> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessCompany mapRow(ResultSet rs, int row) throws SQLException {
			BusinessCompany company = new BusinessCompany();
			try {
				return objectMapperParams.resultObjectFactory(company, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<BusinessCompany> getRowMapper(ObjectMapperParams<BusinessCompany> objectMapperParams) {
		return new CompanyMapper(objectMapperParams);
	}
	
}
