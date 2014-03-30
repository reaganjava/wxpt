package com.reagan.wxpt.dao.impl.system;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.ICommandDao;
import com.reagan.wxpt.pojo.system.SysCommand;

@Repository
public class CommandDaoImpl extends MapperDaoImpl<SysCommand> implements
		ICommandDao {

	class CommandMapper implements RowMapper<SysCommand> {
		
		private ObjectMapperParams<SysCommand> objectMapperParams = null;
		
		public CommandMapper(ObjectMapperParams<SysCommand> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public SysCommand mapRow(ResultSet rs, int row) throws SQLException {
			SysCommand object = new SysCommand();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<SysCommand> getRowMapper(
			ObjectMapperParams<SysCommand> objectMapperParams) {
		
		return new CommandMapper(objectMapperParams);
	}

	
}
