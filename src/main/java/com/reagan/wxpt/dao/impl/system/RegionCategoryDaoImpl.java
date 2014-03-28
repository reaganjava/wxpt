package com.reagan.wxpt.dao.impl.system;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IRegionCategoryDao;
import com.reagan.wxpt.pojo.system.SysRegionCategory;

@Repository
public class RegionCategoryDaoImpl extends MapperDaoImpl<SysRegionCategory>
		implements IRegionCategoryDao {

	class RegionCategoryMapper implements RowMapper<SysRegionCategory> {
		
		private ObjectMapperParams<SysRegionCategory> objectMapperParams = null;

		public RegionCategoryMapper(ObjectMapperParams<SysRegionCategory> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public SysRegionCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
			SysRegionCategory regionCategory = new SysRegionCategory();
			try {
				return objectMapperParams.resultObjectFactory(regionCategory, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	@Override
	public RowMapper<SysRegionCategory> getRowMapper(
			ObjectMapperParams<SysRegionCategory> objectMapperParams) {
		return new RegionCategoryMapper(objectMapperParams);
	}

}
