package com.reagan.wxpt.dao.impl.common;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IMemberActionDao;
import com.reagan.wxpt.pojo.common.CommonMemberAction;

@Repository
public class MemberActionDaoImpl extends MapperDaoImpl<CommonMemberAction> implements
		IMemberActionDao {

	@Override
	public RowMapper<CommonMemberAction> getRowMapper(
			ObjectMapperParams<CommonMemberAction> objectMapperParams) {
		return null;
	}


}
