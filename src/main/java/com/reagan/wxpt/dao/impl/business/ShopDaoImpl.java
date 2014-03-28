package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IShopDao;
import com.reagan.wxpt.pojo.business.BusinessShop;

public class ShopDaoImpl extends MapperDaoImpl<BusinessShop>
		implements IShopDao {

	
	@Override
	public RowMapper<BusinessShop> getRowMapper(
			ObjectMapperParams<BusinessShop> objectMapperParams) {
		return null;
	}

}
