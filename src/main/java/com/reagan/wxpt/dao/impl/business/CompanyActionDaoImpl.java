package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.ICompanyActionDao;
import com.reagan.wxpt.pojo.business.BusinessCompanyAction;

public class CompanyActionDaoImpl extends MapperDaoImpl<BusinessCompanyAction>
		implements ICompanyActionDao {

	
	@Override
	public RowMapper<BusinessCompanyAction> getRowMapper(
			ObjectMapperParams<BusinessCompanyAction> objectMapperParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
