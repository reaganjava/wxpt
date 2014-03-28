package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IPushDao;
import com.reagan.wxpt.pojo.business.BusinessPush;

public class PushDaoImpl extends MapperDaoImpl<BusinessPush>
		implements IPushDao {

	
	@Override
	public RowMapper<BusinessPush> getRowMapper(
			ObjectMapperParams<BusinessPush> objectMapperParams) {
		return null;
	}

}
