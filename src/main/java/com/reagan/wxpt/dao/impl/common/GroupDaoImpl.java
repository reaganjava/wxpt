package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IGroupDao;
import com.reagan.wxpt.pojo.common.CommonGroup;

@Repository
public class GroupDaoImpl extends MapperDaoImpl<CommonGroup> implements IGroupDao {
	
	class GroupMapper implements RowMapper<CommonGroup> {
		
		private ObjectMapperParams<CommonGroup> objectMapperParams;
		
		public GroupMapper(ObjectMapperParams<CommonGroup> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonGroup mapRow(ResultSet rs, int row) throws SQLException {
			CommonGroup group = new CommonGroup();
			try {
				System.out.println(objectMapperParams.columns);
				return objectMapperParams.resultObjectFactory(group, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonGroup> getRowMapper(ObjectMapperParams<CommonGroup> objectMapperParams) {
		return new GroupMapper(objectMapperParams);
	}

}
