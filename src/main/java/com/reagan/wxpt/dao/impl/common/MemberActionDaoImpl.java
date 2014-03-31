package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IMemberActionDao;
import com.reagan.wxpt.pojo.common.CommonMemberAction;

@Repository
public class MemberActionDaoImpl extends MapperDaoImpl<CommonMemberAction> implements
		IMemberActionDao {

	class MemberActionMapper implements RowMapper<CommonMemberAction> {
		
		private ObjectMapperParams<CommonMemberAction> objectMapperParams = null;
		
		public MemberActionMapper(ObjectMapperParams<CommonMemberAction> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonMemberAction mapRow(ResultSet rs, int row) throws SQLException {
			CommonMemberAction object = new CommonMemberAction();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonMemberAction> getRowMapper(
			ObjectMapperParams<CommonMemberAction> objectMapperParams) {
		return new MemberActionMapper(objectMapperParams);
	}


}
