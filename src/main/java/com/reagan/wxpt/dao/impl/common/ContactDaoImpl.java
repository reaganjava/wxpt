package com.reagan.wxpt.dao.impl.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reagan.core.data.dao.impl.MapperDaoImpl;
import com.reagan.core.exception.MapperException;
import com.reagan.core.util.ObjectMapperParams;
import com.reagan.wxpt.dao.common.IContactDao;
import com.reagan.wxpt.pojo.common.CommonContact;

@Repository
public class ContactDaoImpl extends MapperDaoImpl<CommonContact> implements
		IContactDao {

	class ContactMapper implements RowMapper<CommonContact> {
		
		private ObjectMapperParams<CommonContact> objectMapperParams = null;
		
		public ContactMapper(ObjectMapperParams<CommonContact> objectMapperParams) {
			this.objectMapperParams = objectMapperParams;
		}

		@Override
		public CommonContact mapRow(ResultSet rs, int row) throws SQLException {
			CommonContact object = new CommonContact();
			try {
				return objectMapperParams.resultObjectFactory(object, rs);
			} catch (MapperException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
	public RowMapper<CommonContact> getRowMapper(
			ObjectMapperParams<CommonContact> objectMapperParams) {
		return new ContactMapper(objectMapperParams);
	}


}
