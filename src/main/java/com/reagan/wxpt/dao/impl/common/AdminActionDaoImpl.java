package com.reagan.wxpt.dao.impl.common;

import org.springframework.jdbc.core.RowMapper;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IAdminActionDao;
import com.reagan.wxpt.pojo.common.CommonAdminAction;

public class AdminActionDaoImpl extends MapperDaoImpl<CommonAdminAction>
		implements IAdminActionDao {

	@Override
	public RowMapper<CommonAdminAction> getRowMapper(
			ObjectMapperParams<CommonAdminAction> objectMapperParams) {
		return null;
	}


}
