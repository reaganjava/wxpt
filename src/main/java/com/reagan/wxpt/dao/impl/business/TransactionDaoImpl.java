package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.ITransactionDao;
import com.reagan.wxpt.pojo.business.BusinessTransaction;

@Repository
public class TransactionDaoImpl extends MapperDaoImpl<BusinessTransaction>
		implements ITransactionDao {

	class TransactionMapper implements RowMapper<BusinessTransaction> {
		
		private ObjectMapperParams<BusinessTransaction> objectMapperParams = null;
		
		public TransactionMapper(ObjectMapperParams<BusinessTransaction> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessTransaction mapRow(ResultSet rs, int row) throws SQLException {
			BusinessTransaction object = new BusinessTransaction();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<BusinessTransaction> getRowMapper(
			ObjectMapperParams<BusinessTransaction> objectMapperParams) {
		return new TransactionMapper(objectMapperParams);
	}

}
