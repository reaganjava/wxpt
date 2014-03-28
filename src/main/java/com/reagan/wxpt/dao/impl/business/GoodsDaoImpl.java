package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IGoodsDao;
import com.reagan.wxpt.pojo.business.BusinessGoods;

public class GoodsDaoImpl extends MapperDaoImpl<BusinessGoods>
		implements IGoodsDao {

	
	@Override
	public RowMapper<BusinessGoods> getRowMapper(
			ObjectMapperParams<BusinessGoods> objectMapperParams) {
		return null;
	}

}
