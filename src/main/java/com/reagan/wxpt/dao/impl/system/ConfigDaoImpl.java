package com.reagan.wxpt.dao.impl.system;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IConfigDao;
import com.reagan.wxpt.pojo.system.SysConfig;

@Repository
public class ConfigDaoImpl extends MapperDaoImpl<SysConfig> implements IConfigDao{

	class ConfigMapper implements RowMapper<SysConfig> {
		
		private ObjectMapperParams<SysConfig> objectMapperParams = null;
		
		public ConfigMapper(ObjectMapperParams<SysConfig> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public SysConfig mapRow(ResultSet rs, int row) throws SQLException {
			SysConfig object = new SysConfig();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<SysConfig> getRowMapper(
			ObjectMapperParams<SysConfig> objectMapperParams) {
		// TODO Auto-generated method stub
		return new ConfigMapper(objectMapperParams);
	}

}
