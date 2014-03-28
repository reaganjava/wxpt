package com.reagan.wxpt.dao.impl.common;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.ICountiesDao;
import com.reagan.wxpt.pojo.common.CommonCounties;

@Repository
public class CountiesDaoImpl extends MapperDaoImpl<CommonCounties> implements
		ICountiesDao {

	@Override
	public RowMapper<CommonCounties> getRowMapper(
			ObjectMapperParams<CommonCounties> objectMapperParams) {
		return null;
	}


}
