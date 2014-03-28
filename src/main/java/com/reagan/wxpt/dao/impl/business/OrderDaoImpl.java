package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IOrderDao;
import com.reagan.wxpt.pojo.business.BusinessOrder;

public class OrderDaoImpl extends MapperDaoImpl<BusinessOrder>
		implements IOrderDao {

	
	@Override
	public RowMapper<BusinessOrder> getRowMapper(
			ObjectMapperParams<BusinessOrder> objectMapperParams) {
		return null;
	}

}
