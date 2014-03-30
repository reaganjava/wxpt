package com.reagan.wxpt.dao.impl.system;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.system.IAttachmentDao;
import com.reagan.wxpt.pojo.system.SysAttachment;

@Repository
public class AttachmentDaoImpl extends MapperDaoImpl<SysAttachment> implements
		IAttachmentDao {

	class AttachmentMapper implements RowMapper<SysAttachment> {
		
		private ObjectMapperParams<SysAttachment> objectMapperParams = null;
		
		public AttachmentMapper(ObjectMapperParams<SysAttachment> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public SysAttachment mapRow(ResultSet rs, int row) throws SQLException {
			SysAttachment object = new SysAttachment();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<SysAttachment> getRowMapper(
			ObjectMapperParams<SysAttachment> objectMapperParams) {
		// TODO Auto-generated method stub
		return new AttachmentMapper(objectMapperParams);
	}


}
