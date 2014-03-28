package com.reagan.wxpt.dao.impl.system;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IAttachmentDao;
import com.reagan.wxpt.pojo.system.SysAttachment;

@Repository
public class AttachmentDaoImpl extends MapperDaoImpl<SysAttachment> implements
		IAttachmentDao {

	@Override
	public RowMapper<SysAttachment> getRowMapper(
			ObjectMapperParams<SysAttachment> objectMapperParams) {
		// TODO Auto-generated method stub
		return null;
	}


}
