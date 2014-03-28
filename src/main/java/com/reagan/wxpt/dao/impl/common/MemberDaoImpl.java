package com.reagan.wxpt.dao.impl.common;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IMemberDao;
import com.reagan.wxpt.pojo.common.CommonMembers;

@Repository
public class MemberDaoImpl extends MapperDaoImpl<CommonMembers> implements
		IMemberDao {

	@Override
	public RowMapper<CommonMembers> getRowMapper(
			ObjectMapperParams<CommonMembers> objectMapperParams) {
		return null;
	}


}
