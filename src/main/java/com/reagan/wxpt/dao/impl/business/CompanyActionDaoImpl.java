package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.ICompanyActionDao;
import com.reagan.wxpt.pojo.business.BusinessCompanyAction;

@Repository
public class CompanyActionDaoImpl extends MapperDaoImpl<BusinessCompanyAction>
		implements ICompanyActionDao {

	class CompanyActionMapper implements RowMapper<BusinessCompanyAction> {
		
		private ObjectMapperParams<BusinessCompanyAction> objectMapperParams = null;
		
		public CompanyActionMapper(ObjectMapperParams<BusinessCompanyAction> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessCompanyAction mapRow(ResultSet rs, int row) throws SQLException {
			BusinessCompanyAction object = new BusinessCompanyAction();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<BusinessCompanyAction> getRowMapper(
			ObjectMapperParams<BusinessCompanyAction> objectMapperParams) {
		// TODO Auto-generated method stub
		return new CompanyActionMapper(objectMapperParams);
	}

}
