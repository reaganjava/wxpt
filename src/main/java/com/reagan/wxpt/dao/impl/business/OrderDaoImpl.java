package com.reagan.wxpt.dao.impl.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IOrderDao;
import com.reagan.wxpt.pojo.business.BusinessOrder;

@Repository
public class OrderDaoImpl extends MapperDaoImpl<BusinessOrder>
		implements IOrderDao {

	class OrderMapper implements RowMapper<BusinessOrder> {
		
		private ObjectMapperParams<BusinessOrder> objectMapperParams = null;
		
		public OrderMapper(ObjectMapperParams<BusinessOrder> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public BusinessOrder mapRow(ResultSet rs, int row) throws SQLException {
			BusinessOrder object = new BusinessOrder();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<BusinessOrder> getRowMapper(
			ObjectMapperParams<BusinessOrder> objectMapperParams) {
		return new OrderMapper(objectMapperParams);
	}

}
