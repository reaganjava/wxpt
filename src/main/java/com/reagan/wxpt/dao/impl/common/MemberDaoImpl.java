package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IMemberDao;
import com.reagan.wxpt.pojo.common.CommonMembers;

@Repository
public class MemberDaoImpl extends MapperDaoImpl<CommonMembers> implements
		IMemberDao {

	class MemberMapper implements RowMapper<CommonMembers> {
		
		private ObjectMapperParams<CommonMembers> objectMapperParams = null;
		
		public MemberMapper(ObjectMapperParams<CommonMembers> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonMembers mapRow(ResultSet rs, int row) throws SQLException {
			CommonMembers object = new CommonMembers();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonMembers> getRowMapper(
			ObjectMapperParams<CommonMembers> objectMapperParams) {
		return new MemberMapper(objectMapperParams);
	}


}
