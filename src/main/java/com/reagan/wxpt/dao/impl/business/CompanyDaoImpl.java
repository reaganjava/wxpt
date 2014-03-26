package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.JDBCDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectParams;
import com.reagan.wxpt.dao.business.ICompanyDao;
import com.reagan.wxpt.pojo.business.BusinessCompany;

public class CompanyDaoImpl extends JDBCDaoImpl<BusinessCompany> implements ICompanyDao {

	class CompanyMapper implements RowMapper<BusinessCompany> {
		@Override
		public BusinessCompany mapRow(ResultSet rs, int row) throws SQLException {
			BusinessCompany company = new BusinessCompany();
			ObjectParams<BusinessCompany> objectParams = new ObjectParams<BusinessCompany>();
			try {
				return objectParams.resultObjectFactory(company, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<BusinessCompany> getRowMapper() {
		return new CompanyMapper();
	}
	
}
