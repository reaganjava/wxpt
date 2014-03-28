package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.ITransactionDao;
import com.reagan.wxpt.pojo.business.BusinessTransaction;

public class TransactionDaoImpl extends MapperDaoImpl<BusinessTransaction>
		implements ITransactionDao {

	
	@Override
	public RowMapper<BusinessTransaction> getRowMapper(
			ObjectMapperParams<BusinessTransaction> objectMapperParams) {
		return null;
	}

}
