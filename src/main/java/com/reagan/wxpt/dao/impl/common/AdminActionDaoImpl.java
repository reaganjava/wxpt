package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IAdminActionDao;
import com.reagan.wxpt.pojo.business.BusinessTransaction;
import com.reagan.wxpt.pojo.common.CommonAdminAction;

@Repository
public class AdminActionDaoImpl extends MapperDaoImpl<CommonAdminAction>
		implements IAdminActionDao {

	class AdminActionMapper implements RowMapper<CommonAdminAction> {
		
		private ObjectMapperParams<CommonAdminAction> objectMapperParams = null;
		
		public AdminActionMapper(ObjectMapperParams<CommonAdminAction> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonAdminAction mapRow(ResultSet rs, int row) throws SQLException {
			CommonAdminAction object = new CommonAdminAction();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonAdminAction> getRowMapper(
			ObjectMapperParams<CommonAdminAction> objectMapperParams) {
		return new AdminActionMapper(objectMapperParams);
	}


}
