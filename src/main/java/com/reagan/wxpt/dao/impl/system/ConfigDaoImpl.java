package com.reagan.wxpt.dao.impl.system;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IConfigDao;
import com.reagan.wxpt.pojo.system.SysConfig;

@Repository
public class ConfigDaoImpl extends MapperDaoImpl<SysConfig> implements IConfigDao{


	@Override
	public RowMapper<SysConfig> getRowMapper(
			ObjectMapperParams<SysConfig> objectMapperParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
