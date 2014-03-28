package com.reagan.wxpt.dao.impl.common;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IFractionDao;
import com.reagan.wxpt.pojo.common.CommonFraction;

public class FractionDaoImpl extends MapperDaoImpl<CommonFraction> implements
		IFractionDao {

	@Override
	public RowMapper<CommonFraction> getRowMapper(
			ObjectMapperParams<CommonFraction> objectMapperParams) {
		return null;
	}


}
