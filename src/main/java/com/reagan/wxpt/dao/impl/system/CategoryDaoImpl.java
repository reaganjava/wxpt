package com.reagan.wxpt.dao.impl.system;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.ICategoryDao;
import com.reagan.wxpt.pojo.system.SysCategory;

@Repository
public class CategoryDaoImpl extends MapperDaoImpl<SysCategory> implements
		ICategoryDao {


	class CategoryMapper implements RowMapper<SysCategory> {
		
		private ObjectMapperParams<SysCategory> objectMapperParams = null;
		
		public CategoryMapper(ObjectMapperParams<SysCategory> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public SysCategory mapRow(ResultSet rs, int row) throws SQLException {
			SysCategory object = new SysCategory();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<SysCategory> getRowMapper(
			ObjectMapperParams<SysCategory> objectMapperParams) {
		return new CategoryMapper(objectMapperParams);
	}


}
