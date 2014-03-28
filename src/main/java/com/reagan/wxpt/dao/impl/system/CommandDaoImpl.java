package com.reagan.wxpt.dao.impl.system;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.ICommandDao;
import com.reagan.wxpt.pojo.system.SysCommand;

public class CommandDaoImpl extends MapperDaoImpl<SysCommand> implements
		ICommandDao {

	@Override
	public RowMapper<SysCommand> getRowMapper(
			ObjectMapperParams<SysCommand> objectMapperParams) {
		
		return null;
	}

	
}
