package com.reagan.wxpt.dao.impl.business;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.business.IGoodsDao;
import com.reagan.wxpt.pojo.business.BusinessGoods;

@Repository
public class GoodsDaoImpl extends MapperDaoImpl<BusinessGoods>
		implements IGoodsDao {

	
	@Override
	public RowMapper<BusinessGoods> getRowMapper(
			ObjectMapperParams<BusinessGoods> objectMapperParams) {
		return null;
	}

}
